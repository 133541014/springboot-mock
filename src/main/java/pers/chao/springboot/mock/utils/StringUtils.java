package pers.chao.springboot.mock.utils;

/**
 * д��ʲô��
 *
 * @author WangYichao
 * @date 2019/4/28 10:00
 */
public final class StringUtils {

    private StringUtils() {

        throw new RuntimeException("�����಻��Ҫ��ʵ����");
    }

    /**
     * �ַ�������ĸתСд
     * @param str �ַ���
     * @return
     */
    public static String firstCharToLowerCase(String str){

        String firstChar = str.substring(0, 1);
        firstChar = firstChar.toLowerCase();
        str = firstChar+str.substring(1,str.length());

        return str;
    }
}
