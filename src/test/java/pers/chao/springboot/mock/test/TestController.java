package pers.chao.springboot.mock.test;

import org.junit.Test;
import pers.chao.springboot.mock.annotation.Autowired;
import pers.chao.springboot.mock.annotation.Controller;

/**
 * –¥µ„ ≤√¥∞…
 *
 * @author WangYichao
 * @date 2019/4/28 10:27
 */
@Controller()
public class TestController {

    @Autowired
    private TestService testService;
}
