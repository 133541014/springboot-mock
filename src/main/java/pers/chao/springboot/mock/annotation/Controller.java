package pers.chao.springboot.mock.annotation;

import java.lang.annotation.*;

/**
 * Controller
 *
 * @author WangYichao
 * @date 2019/4/27 13:05
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Controller {

    String value() default "";
}
