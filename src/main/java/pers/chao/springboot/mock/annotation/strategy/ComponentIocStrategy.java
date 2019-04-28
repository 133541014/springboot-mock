package pers.chao.springboot.mock.annotation.strategy;

import lombok.extern.slf4j.Slf4j;
import pers.chao.springboot.mock.annotation.Component;
import pers.chao.springboot.mock.utils.StringUtils;

import java.util.Map;

/**
 * É¨Ãè{@code @Component} ×¢½â×¢²áiocÈÝÆ÷
 *
 * @author WangYichao
 * @date 2019/4/28 10:18
 */
@Slf4j
public class ComponentIocStrategy implements AnnotationIocStrategy{
    @Override
    public void doRegistry(Class<?> clazz, Map<String, Object> ioc) {
        try {
            Component component = clazz.getAnnotation(Component.class);
            checkBeanNameExist(clazz,ioc,component.value());
            if("".equals(component.value())){

                ioc.put(StringUtils.firstCharToLowerCase(clazz.getSimpleName()),clazz.newInstance());
            }else {

                ioc.put(component.value(),clazz.newInstance());
            }
        } catch (Exception e) {
            log.error("@Component ×¢²áiocÈÝÆ÷Ê§°Ü",e);
        }
    }
}
