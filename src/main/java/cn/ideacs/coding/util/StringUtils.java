package cn.ideacs.coding.util;

/**
 * 字符串工具类
 */
public class StringUtils {
    /**
     * 判断字符串是否为空对应或者是空字符串。
     * @param str
     * @return
     */
     public static Boolean isEmpty(String str) {
         return str == null || "".equals(str);
     }

    /**
     * 判断字符串是否为非空字符串。
     * @param str
     * @return
     */
     public static Boolean isNotEmpty(String str) {
        return !isEmpty(str);
     }

    /**
     * 替换掉字符串中所有对应的字符为目标字符
     * @param str       操作字符串
     * @param source    原字符
     * @param target    目标字符
     * @return
     */
     public static String replaceAll(String str, Character source, Character target) {
        return str.replace(source, target);
     }

}
