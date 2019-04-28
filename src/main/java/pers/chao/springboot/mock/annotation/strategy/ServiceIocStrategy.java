package pers.chao.springboot.mock.annotation.strategy;

import lombok.extern.slf4j.Slf4j;
import pers.chao.springboot.mock.annotation.Service;
import pers.chao.springboot.mock.utils.StringUtils;

import java.util.Map;

/**
 * É¨Ãè{@code @Service} ×¢½â×¢²áiocÈÝÆ÷
 *
 * @author WangYichao
 * @date 2019/4/28 10:17
 */
@Slf4j
public class ServiceIocStrategy implements AnnotationIocStrategy {

    @Override
    public void doRegistry(Class<?> clazz, Map<String, Object> ioc) {
        try {
            Service service = clazz.getAnnotation(Service.class);
            checkBeanNameExist(clazz, ioc, service.value());
            if ("".equals(service.value())) {
                ioc.put(StringUtils.firstCharToLowerCase(clazz.getSimpleName()), clazz.newInstance());
            } else {
                ioc.put(service.value(), clazz.newInstance());
            }
        } catch (Exception e) {
            log.error("@Service ×¢²áiocÈÝÆ÷Ê§°Ü", e);
        }
    }
}
