package pers.chao.springboot.mock.annotation;

import java.lang.annotation.*;

/**
 * ��ʶ������ע��
 *
 * @author WangYichao
 * @date 2019/4/27 12:20
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SpringBootApplication {
}
