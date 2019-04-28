package pers.chao.springboot.mock.annotation.strategy;

import pers.chao.springboot.mock.utils.StringUtils;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * iocע��ע�����
 *
 * @author WangYichao
 * @date 2019/4/28 9:55
 */
public interface AnnotationIocStrategy {

    /**
     * ע��ioc����
     *
     * @param clazz class����
     * @param ioc   ioc����
     */
    void doRegistry(Class<?> clazz, Map<String, Object> ioc);

    default void checkBeanNameExist(Class<?> clazz, Map<String, Object> ioc, String value) {
        boolean hasValue = ioc.get(value) != null;
        boolean valueIsEmpty = "".equals(value);
        if ((valueIsEmpty && ioc.get(StringUtils.firstCharToLowerCase(clazz.getSimpleName())) != null) || hasValue) {
            throw new RuntimeException(clazz.getSimpleName() + " ��ioc�������Ѿ�����,�����ظ�ע��");
        }
    }


}
