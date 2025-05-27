package cn.lili.modules.order.cart.service;

import cn.lili.cache.Cache;
import cn.lili.common.enums.PromotionTypeEnum;
import cn.lili.common.enums.ResultCode;
import cn.lili.common.exception.ServiceException;
import cn.lili.common.security.AuthUser;
import cn.lili.common.security.context.UserContext;
import cn.lili.common.utils.CurrencyUtil;
import cn.lili.modules.goods.entity.dos.GoodsSku;
import cn.lili.modules.goods.entity.enums.GoodsAuthEnum;
import cn.lili.modules.goods.entity.enums.GoodsStatusEnum;
import cn.lili.modules.goods.entity.enums.GoodsTypeEnum;
import cn.lili.modules.goods.service.GoodsSkuService;
import cn.lili.modules.member.entity.dos.MemberAddress;
import cn.lili.modules.member.service.MemberAddressService;
import cn.lili.modules.member.service.MemberService;
import cn.lili.modules.order.cart.entity.dto.MemberCouponDTO;
import cn.lili.modules.order.cart.entity.dto.TradeDTO;
import cn.lili.modules.order.cart.entity.enums.CartTypeEnum;
import cn.lili.modules.order.cart.entity.vo.CartSkuVO;
import cn.lili.modules.order.cart.entity.vo.TradeParams;
import cn.lili.modules.order.cart.render.TradeBuilder;
import cn.lili.modules.order.order.entity.dos.Trade;
import cn.lili.modules.order.order.entity.vo.PriceDetailVO;
import cn.lili.modules.promotion.entity.dos.MemberCoupon;
import cn.lili.modules.promotion.entity.enums.CouponTypeEnum;
import cn.lili.modules.promotion.entity.enums.MemberCouponStatusEnum;
import cn.lili.modules.promotion.entity.enums.PromotionsScopeTypeEnum;
import cn.lili.modules.promotion.service.MemberCouponService;
import cn.lili.modules.promotion.service.PromotionGoodsService;
import cn.lili.modules.search.service.EsGoodsSearchService;
import cn.lili.modules.store.service.StoreAddressService;
import cn.lili.modules.store.service.StoreService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CartServiceImplTest {

    @InjectMocks
    @Spy // Using Spy to allow partial mocking if CartServiceImpl.checkCoupon is called
    private CartServiceImpl cartService;

    @Mock
    private Cache<Object> cache;
    @Mock
    private MemberCouponService memberCouponService;
    @Mock
    private GoodsSkuService goodsSkuService;
    @Mock
    private TradeBuilder tradeBuilder;
    @Mock
    private MemberAddressService memberAddressService;
    @Mock
    private EsGoodsSearchService esGoodsSearchService;
    @Mock
    private PromotionGoodsService promotionGoodsService;
    // @Mock private WholesaleService wholesaleService; // Not directly used in the flow being tested
    // @Mock private StoreService storeService; // Not directly used in the flow being tested
    // @Mock private StoreAddressService storeAddressService; // Not directly used in the flow being tested
    @Mock
    private MemberService memberService; // Not directly used but can be mocked

    private static final String SKU_ID_1 = "SKU123";
    private static final String COUPON_ID_1 = "COUPON456";
    private static final String STORE_ID_1 = "STORE789";
    private static final String MEMBER_ID = "MEMBER001";
    private static final Double INITIAL_PRICE = 50.00;
    private static final Double UPDATED_PRICE = 30.00;
    private static final Double COUPON_THRESHOLD = 40.00;
    private static final Double COUPON_DISCOUNT_PRICE = 10.00; // Example: fixed amount for simplicity

    @BeforeEach
    void setUp() {
        AuthUser authUser = new AuthUser("testUser", MEMBER_ID, "testPass", "test@example.com", true);
        UserContext.setAuthUser(authUser);

        // Mock default member address to avoid NPE if tradeDTO.getMemberAddress() is null
        MemberAddress mockAddress = new MemberAddress();
        mockAddress.setId("DEFAULT_ADDRESS_ID");
        mockAddress.setConsignee("Test User");
        // ... set other required fields for MemberAddress
        when(memberAddressService.getDefaultMemberAddress()).thenReturn(mockAddress);
        // Also mock getById for the default address if it's re-fetched, though not expected in this flow
        when(memberAddressService.getById(anyString())).thenReturn(mockAddress);

    }

    @AfterEach
    void tearDown() {
        UserContext.remove();
    }

    @Test
    void testCreateTrade_PriceDropInvalidatesCoupon() {
        // 1. Prepare initial TradeDTO (item at 50.00, coupon applied)
        TradeDTO initialTradeDTO = new TradeDTO(CartTypeEnum.CART);
        initialTradeDTO.setMemberId(MEMBER_ID);

        GoodsSku initialSku = new GoodsSku();
        initialSku.setId(SKU_ID_1);
        initialSku.setGoodsId("GOODS001");
        initialSku.setPrice(INITIAL_PRICE);
        initialSku.setMarketEnable(GoodsStatusEnum.UPPER.name());
        initialSku.setAuthFlag(GoodsAuthEnum.PASS.name());
        initialSku.setGoodsType(GoodsTypeEnum.PHYSICAL_GOODS.name()); // Ensure it's not VIRTUAL for address check
        initialSku.setStoreId(STORE_ID_1); // Set storeId for store coupon association

        CartSkuVO cartSkuVO = new CartSkuVO(initialSku, new HashMap<>());
        cartSkuVO.setNum(1);
        cartSkuVO.setPurchasePrice(INITIAL_PRICE);
        cartSkuVO.setChecked(true);
        cartSkuVO.setStoreId(STORE_ID_1);
        initialTradeDTO.setSkuList(Collections.singletonList(cartSkuVO));
        initialTradeDTO.setMemberAddress(memberAddressService.getDefaultMemberAddress());


        MemberCoupon storeCoupon = new MemberCoupon();
        storeCoupon.setId(COUPON_ID_1);
        storeCoupon.setMemberId(MEMBER_ID);
        storeCoupon.setStoreId(STORE_ID_1);
        storeCoupon.setConsumeThreshold(COUPON_THRESHOLD);
        storeCoupon.setCouponType(CouponTypeEnum.PRICE.name()); // e.g. PRICE discount
        storeCoupon.setPrice(COUPON_DISCOUNT_PRICE); // 10 dollar off
        storeCoupon.setPlatformFlag(false); // Store coupon
        storeCoupon.setStatus(MemberCouponStatusEnum.NEW.name());
        storeCoupon.setScopeType(PromotionsScopeTypeEnum.ALL.name()); // Applies to all goods in store for simplicity

        Map<String, Double> skuDetail = new HashMap<>();
        skuDetail.put(SKU_ID_1, INITIAL_PRICE * cartSkuVO.getNum());

        MemberCouponDTO memberCouponDTO = new MemberCouponDTO(skuDetail, storeCoupon);
        initialTradeDTO.setStoreCoupons(new HashMap<>(Collections.singletonMap(STORE_ID_1, memberCouponDTO)));
        
        // PriceDetailVO for initial TradeDTO (before any calculation in TradeBuilder)
        PriceDetailVO initialPriceDetail = new PriceDetailVO();
        initialPriceDetail.setGoodsPrice(INITIAL_PRICE);
        initialPriceDetail.setDiscountPrice(COUPON_DISCOUNT_PRICE); // Assuming coupon is initially applied
        initialPriceDetail.setFlowPrice(INITIAL_PRICE - COUPON_DISCOUNT_PRICE);
        initialTradeDTO.setPriceDetailVO(initialPriceDetail);


        // 2. Mock Cache to return this initialTradeDTO
        when(cache.get(eq(CartTypeEnum.CART.getPrefix() + MEMBER_ID))).thenReturn(initialTradeDTO);

        // 3. Mock GoodsSkuService: Return updated price during re-validation
        GoodsSku updatedSku = new GoodsSku();
        updatedSku.setId(SKU_ID_1);
        updatedSku.setGoodsId("GOODS001");
        updatedSku.setPrice(UPDATED_PRICE); // Price dropped to 30.00
        updatedSku.setMarketEnable(GoodsStatusEnum.UPPER.name());
        updatedSku.setAuthFlag(GoodsAuthEnum.PASS.name());
        updatedSku.setGoodsType(GoodsTypeEnum.PHYSICAL_GOODS.name());
        updatedSku.setStoreId(STORE_ID_1);
        // This is the crucial mock for the re-validation step
        when(goodsSkuService.getGoodsSkuByIdFromCache(SKU_ID_1)).thenReturn(updatedSku);


        // 4. Mock MemberCouponService: Return the valid coupon when re-fetched
        when(memberCouponService.getById(COUPON_ID_1)).thenReturn(storeCoupon);
        
        // (Spying CartServiceImpl to use its actual checkCoupon method with updated SKU prices)
        // No need to mock checkCoupon directly, as the spy will use the real method.
        // The real checkCoupon will receive the TradeDTO with SKUs having updated prices.

        // 5. Mock TradeBuilder
        ArgumentCaptor<TradeDTO> tradeDTOCaptor = ArgumentCaptor.forClass(TradeDTO.class);
        Trade mockFinalTrade = new Trade(); // Dummy trade object
        PriceDetailVO finalPriceDetail = new PriceDetailVO();
        // We expect the final goods price to be the updated SKU price, and no coupon discount
        finalPriceDetail.setGoodsPrice(UPDATED_PRICE); 
        finalPriceDetail.setDiscountPrice(0.0); // No coupon discount
        finalPriceDetail.setFlowPrice(UPDATED_PRICE);
        mockFinalTrade.setPriceDetailVO(finalPriceDetail);
        
        when(tradeBuilder.createTrade(tradeDTOCaptor.capture())).thenReturn(mockFinalTrade);

        // 6. Call createTrade
        TradeParams tradeParams = new TradeParams();
        tradeParams.setWay(CartTypeEnum.CART.name());
        // tradeParams.setClientType(ClientTypeEnum.PC.name()); // Set if necessary

        Trade resultTrade = cartService.createTrade(tradeParams);

        // 7. Assertions
        verify(tradeBuilder).createTrade(any(TradeDTO.class));
        TradeDTO capturedTradeDTO = tradeDTOCaptor.getValue();

        // Assert coupon is no longer applied for the store
        assertTrue(capturedTradeDTO.getStoreCoupons() == null ||
                   capturedTradeDTO.getStoreCoupons().get(STORE_ID_1) == null ||
                   capturedTradeDTO.getStoreCoupons().get(STORE_ID_1).getMemberCoupon() == null, // Check if coupon DTO itself is null or its inner coupon
                   "Store coupon should be null or not applied after price drop made it invalid.");
        
        // Assert SKU price in the captured DTO reflects the updated price
        assertNotNull(capturedTradeDTO.getSkuList(), "SKU list in captured TradeDTO should not be null.");
        assertEquals(1, capturedTradeDTO.getSkuList().size(), "Captured TradeDTO should have one SKU.");
        CartSkuVO capturedSkuVO = capturedTradeDTO.getSkuList().get(0);
        assertEquals(UPDATED_PRICE, capturedSkuVO.getPurchasePrice(), "SKU purchase price should be the updated price.");
        assertEquals(UPDATED_PRICE, capturedSkuVO.getGoodsSku().getPrice(), "GoodsSku price within CartSkuVO should be the updated price.");

        // Assert final trade object's price reflects the new item price without discount
        assertNotNull(resultTrade, "Resulting trade should not be null.");
        assertNotNull(resultTrade.getPriceDetailVO(), "PriceDetailVO in result trade should not be null.");
        assertEquals(UPDATED_PRICE, resultTrade.getPriceDetailVO().getGoodsPrice(), "Final trade goods price should be updated price.");
        assertEquals(0.0, resultTrade.getPriceDetailVO().getDiscountPrice(), "Final trade discount should be 0 as coupon is invalid.");
        assertEquals(UPDATED_PRICE, resultTrade.getPriceDetailVO().getFlowPrice(), "Final trade flow price should be updated price.");

        // Verify cache.put was called to reset/clean the cart for this user and cart type
        verify(cache).put(eq(CartTypeEnum.CART.getPrefix() + MEMBER_ID), any(TradeDTO.class));
    }
}
