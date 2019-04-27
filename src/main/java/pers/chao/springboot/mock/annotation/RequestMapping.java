package pers.chao.springboot.mock.annotation;

import java.lang.annotation.*;

/**
 * RequestMapping
 *
 * @author WangYichao
 * @date 2019/4/27 20:02
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface RequestMapping {

    String value() default "";
}
