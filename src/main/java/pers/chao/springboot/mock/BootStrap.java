package pers.chao.springboot.mock;

import pers.chao.springboot.mock.annotation.SpringBootApplication;
import pers.chao.springboot.mock.core.ApplicationContext;
import pers.chao.springboot.mock.core.SpringApplication;

/**
 * –¥µ„ ≤√¥∞…
 *
 * @author WangYichao
 * @date 2019/4/27 18:36
 */
@SpringBootApplication
public class BootStrap {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BootStrap.class, args);
    }
}
