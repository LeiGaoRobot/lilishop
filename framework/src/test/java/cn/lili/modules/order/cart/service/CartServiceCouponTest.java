package cn.lili.modules.order.cart.service;

import cn.lili.modules.goods.entity.dos.GoodsSku;
import cn.lili.modules.order.cart.entity.dto.TradeDTO;
import cn.lili.modules.order.cart.entity.vo.CartSkuVO;
import cn.lili.modules.promotion.entity.dos.MemberCoupon;
import cn.lili.modules.promotion.entity.enums.PromotionsScopeTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CartServiceCouponTest {

    @Test
    public void testCheckCouponCategoryPath() throws Exception {
        CartServiceImpl cartService = new CartServiceImpl();
        Method checkCouponMethod = CartServiceImpl.class.getDeclaredMethod("checkCoupon", MemberCoupon.class, TradeDTO.class);
        checkCouponMethod.setAccessible(true);

        MemberCoupon memberCoupon = new MemberCoupon();
        memberCoupon.setPlatformFlag(true);
        memberCoupon.setScopeType(PromotionsScopeTypeEnum.PORTION_GOODS_CATEGORY.name());
        // Coupon applies to categories 10 and 20
        memberCoupon.setScopeId("10,20");

        TradeDTO tradeDTO = new TradeDTO();
        List<CartSkuVO> skuList = new ArrayList<>();

        // SKU in category 10 (Direct match)
        CartSkuVO sku1 = new CartSkuVO();
        GoodsSku goodsSku1 = new GoodsSku();
        goodsSku1.setCategoryPath("10");
        sku1.setGoodsSku(goodsSku1);
        skuList.add(sku1);

        // SKU in subcategory of 10 (Path intersects)
        CartSkuVO sku2 = new CartSkuVO();
        GoodsSku goodsSku2 = new GoodsSku();
        goodsSku2.setCategoryPath("10,15,30");
        sku2.setGoodsSku(goodsSku2);
        skuList.add(sku2);

        // SKU in subcategory of 20 (Path intersects)
        CartSkuVO sku3 = new CartSkuVO();
        GoodsSku goodsSku3 = new GoodsSku();
        goodsSku3.setCategoryPath("5,20,50");
        sku3.setGoodsSku(goodsSku3);
        skuList.add(sku3);

        // SKU in totally different category (No match)
        CartSkuVO sku4 = new CartSkuVO();
        GoodsSku goodsSku4 = new GoodsSku();
        goodsSku4.setCategoryPath("100,200");
        sku4.setGoodsSku(goodsSku4);
        skuList.add(sku4);

        tradeDTO.setSkuList(skuList);

        @SuppressWarnings("unchecked")
        List<CartSkuVO> result = (List<CartSkuVO>) checkCouponMethod.invoke(cartService, memberCoupon, tradeDTO);

        // sku1, sku2, sku3 should match. sku4 should not match.
        Assertions.assertEquals(3, result.size());
        Assertions.assertTrue(result.contains(sku1));
        Assertions.assertTrue(result.contains(sku2));
        Assertions.assertTrue(result.contains(sku3));
        Assertions.assertFalse(result.contains(sku4));
    }

    @Test
    public void testCheckCouponStoreCategoryPath() throws Exception {
        CartServiceImpl cartService = new CartServiceImpl();
        Method checkCouponMethod = CartServiceImpl.class.getDeclaredMethod("checkCoupon", MemberCoupon.class, TradeDTO.class);
        checkCouponMethod.setAccessible(true);

        MemberCoupon memberCoupon = new MemberCoupon();
        memberCoupon.setPlatformFlag(true);
        memberCoupon.setScopeType(PromotionsScopeTypeEnum.PORTION_SHOP_CATEGORY.name());
        memberCoupon.setScopeId("30,40");

        TradeDTO tradeDTO = new TradeDTO();
        List<CartSkuVO> skuList = new ArrayList<>();

        CartSkuVO sku1 = new CartSkuVO();
        GoodsSku goodsSku1 = new GoodsSku();
        goodsSku1.setStoreCategoryPath("30,50");
        sku1.setGoodsSku(goodsSku1);
        skuList.add(sku1);

        CartSkuVO sku2 = new CartSkuVO();
        GoodsSku goodsSku2 = new GoodsSku();
        goodsSku2.setStoreCategoryPath("99");
        sku2.setGoodsSku(goodsSku2);
        skuList.add(sku2);

        tradeDTO.setSkuList(skuList);

        @SuppressWarnings("unchecked")
        List<CartSkuVO> result = (List<CartSkuVO>) checkCouponMethod.invoke(cartService, memberCoupon, tradeDTO);

        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains(sku1));
    }
}
