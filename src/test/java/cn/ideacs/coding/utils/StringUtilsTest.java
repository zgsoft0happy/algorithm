package cn.ideacs.coding.utils;

import cn.ideacs.coding.util.StringUtils;
import static org.junit.Assert.*;
import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void should_check_str_is_empty() {
        String str = null;
        assertTrue(StringUtils.isEmpty(str));
        str = "";
        assertTrue(StringUtils.isEmpty(str));
        str = "null";
        assertFalse(StringUtils.isEmpty(str));
    }

    @Test
    public void should_check_str_is_not_empty() {
        String str = null;
        assertFalse(StringUtils.isNotEmpty(str));
        str = "";
        assertFalse(StringUtils.isNotEmpty(str));
        str = "null";
        assertTrue(StringUtils.isNotEmpty(str));
    }

    @Test
    public void should_replace_all_matcher_char() {
        String str = "henansheng";
        assertEquals("henansheng", str);
        str = StringUtils.replaceAll(str, 'n', 'm');
        assertEquals("hemamshemg", str);
    }

}
