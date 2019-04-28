package pers.chao.springboot.mock.utils;

/**
 * 写点什么吧
 *
 * @author WangYichao
 * @date 2019/4/28 10:00
 */
public final class StringUtils {

    private StringUtils() {

        throw new RuntimeException("工具类不需要被实例化");
    }

    /**
     * 字符串首字母转小写
     * @param str 字符串
     * @return
     */
    public static String firstCharToLowerCase(String str){

        String firstChar = str.substring(0, 1);
        firstChar = firstChar.toLowerCase();
        str = firstChar+str.substring(1,str.length());

        return str;
    }
}
