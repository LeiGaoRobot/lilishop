package cn.lili.common.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    @Test
    public void testGetRandStr() {
        String rand1 = StringUtils.getRandStr(10);
        assertEquals(10, rand1.length());

        String rand2 = StringUtils.getRandStr(100);
        assertEquals(100, rand2.length());
    }

    @Test
    public void testCamel2Underline() {
        assertEquals("user_name", StringUtils.camel2Underline("userName"));
        assertEquals("user_name_test", StringUtils.camel2Underline("userNameTest"));
        assertEquals("user", StringUtils.camel2Underline("user"));
    }
}
