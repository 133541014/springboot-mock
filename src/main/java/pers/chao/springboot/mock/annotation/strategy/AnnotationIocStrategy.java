package pers.chao.springboot.mock.annotation.strategy;

import pers.chao.springboot.mock.utils.StringUtils;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * ioc注解注册策略
 *
 * @author WangYichao
 * @date 2019/4/28 9:55
 */
public interface AnnotationIocStrategy {

    /**
     * 注册ioc容器
     *
     * @param clazz class对象
     * @param ioc   ioc容器
     */
    void doRegistry(Class<?> clazz, Map<String, Object> ioc);

    default void checkBeanNameExist(Class<?> clazz, Map<String, Object> ioc, String value) {
        boolean hasValue = ioc.get(value) != null;
        boolean valueIsEmpty = "".equals(value);
        if ((valueIsEmpty && ioc.get(StringUtils.firstCharToLowerCase(clazz.getSimpleName())) != null) || hasValue) {
            throw new RuntimeException(clazz.getSimpleName() + " 在ioc容器中已经存在,请勿重复注册");
        }
    }


}
