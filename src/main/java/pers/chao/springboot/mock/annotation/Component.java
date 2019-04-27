package pers.chao.springboot.mock.annotation;

import java.lang.annotation.*;

/**
 * Component
 *
 * @author WangYichao
 * @date 2019/4/27 18:09
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";
}
