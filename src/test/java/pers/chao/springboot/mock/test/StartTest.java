package pers.chao.springboot.mock.test;

import org.junit.Test;
import pers.chao.springboot.mock.annotation.SpringBootApplication;
import pers.chao.springboot.mock.core.ApplicationContext;
import pers.chao.springboot.mock.core.SpringApplication;

/**
 * –¥µ„ ≤√¥∞…
 *
 * @author WangYichao
 * @date 2019/4/27 18:32
 */
@SpringBootApplication
public class StartTest {

    @Test
    public void testStart(){
        ApplicationContext context = SpringApplication.run(StartTest.class);
        
    }
}
