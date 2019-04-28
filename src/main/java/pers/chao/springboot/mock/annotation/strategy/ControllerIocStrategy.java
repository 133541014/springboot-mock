package pers.chao.springboot.mock.annotation.strategy;

import lombok.extern.slf4j.Slf4j;
import pers.chao.springboot.mock.annotation.Controller;
import pers.chao.springboot.mock.utils.StringUtils;

import java.util.Map;

/**
 * ɨ��{@code @Controller} ע��ע��ioc����
 *
 * @author WangYichao
 * @date 2019/4/28 9:59
 */
@Slf4j
public class ControllerIocStrategy implements AnnotationIocStrategy{

    @Override
    public void doRegistry(Class<?> clazz, Map<String, Object> ioc) {
        try {
            Controller controller = clazz.getAnnotation(Controller.class);
            checkBeanNameExist(clazz,ioc,controller.value());
            if("".equals(controller.value())){
                if(ioc.get(clazz.getSimpleName())!=null){
                    throw new RuntimeException(clazz.getSimpleName()+" ��ioc�������Ѿ�����,�����ظ�ע��");
                }
                ioc.put(StringUtils.firstCharToLowerCase(clazz.getSimpleName()),clazz.newInstance());
            }else {
                if(ioc.get(controller.value())!=null){
                    throw new RuntimeException(clazz.getSimpleName()+" ��ioc�������Ѿ�����,�����ظ�ע��");
                }
                ioc.put(controller.value(),clazz.newInstance());
            }
        } catch (Exception e) {
            log.error("@Controller ע��ioc����ʧ��",e);
        }
    }

}
