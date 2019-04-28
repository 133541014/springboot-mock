package pers.chao.springboot.mock.annotation.factory;

import pers.chao.springboot.mock.annotation.Component;
import pers.chao.springboot.mock.annotation.Controller;
import pers.chao.springboot.mock.annotation.Service;
import pers.chao.springboot.mock.annotation.strategy.AnnotationIocStrategy;
import pers.chao.springboot.mock.annotation.strategy.ComponentIocStrategy;
import pers.chao.springboot.mock.annotation.strategy.ControllerIocStrategy;
import pers.chao.springboot.mock.annotation.strategy.ServiceIocStrategy;
import pers.chao.springboot.mock.utils.StringUtils;

/**
 * ioc ×¢½âÉ¨Ãè¹¤³§
 *
 * @author WangYichao
 * @date 2019/4/28 10:22
 */
public class AnnotationIocFactory {

    public static AnnotationIocStrategy getStrategy(Class<?> clazz){
        if(clazz.isAnnotationPresent(Controller.class)){

            return new ControllerIocStrategy();

        }else if(clazz.isAnnotationPresent(Service.class)){

            return new ServiceIocStrategy();

        }else if(clazz.isAnnotationPresent(Component.class)){

            return new ComponentIocStrategy();
        }

        return null;
    }
}
