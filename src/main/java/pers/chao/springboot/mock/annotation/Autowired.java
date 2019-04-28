package pers.chao.springboot.mock.annotation;

import java.lang.annotation.*;

/**
 * Autowired
 *
 * @author WangYichao
 * @date 2019/4/28 10:32
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {

    String value() default "";
}
