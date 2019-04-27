package pers.chao.springboot.mock.annotation;

import java.lang.annotation.*;

/**
 * Service
 *
 * @author WangYichao
 * @date 2019/4/27 13:05
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Service {

    String value() default "";
}
