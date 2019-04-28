package pers.chao.springboot.mock.core;

import lombok.extern.slf4j.Slf4j;
import pers.chao.springboot.mock.annotation.Autowired;
import pers.chao.springboot.mock.annotation.Component;
import pers.chao.springboot.mock.annotation.Controller;
import pers.chao.springboot.mock.annotation.Service;
import pers.chao.springboot.mock.annotation.factory.AnnotationIocFactory;
import pers.chao.springboot.mock.annotation.strategy.AnnotationIocStrategy;
import pers.chao.springboot.mock.utils.StringUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ApplicationContext
 *
 * @author WangYichao
 * @date 2019/4/27 12:38
 */
@Slf4j
public class ApplicationContext {

    /**
     * ioc����
     */
    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    /**
     * �ļ�ϵͳ�ָ���
     */
    private static final String SEPARATOR = "/";

    /**
     * ɨ�����������������
     */
    private List<String> scanClassNames = new ArrayList<>();

    public void init(String scanPackage) {
        scanPackageFile(scanPackage);
        //ע��ioc����
        doRegistry();
        //����ע��
        doAutowired();

        log.info("�����Ѿ���ʼ��");
    }

    /**
     * ����ע��
     */
    private void doAutowired() {
        try {
            Set<Map.Entry<String, Object>> entrySet = ioc.entrySet();
            for (Map.Entry<String, Object> entry : entrySet) {
                Object bean = entry.getValue();
                Field[] fields = bean.getClass().getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (!field.isAnnotationPresent(Autowired.class)) {
                        continue;
                    }
                    Autowired autowired = field.getAnnotation(Autowired.class);
                    String beanName = "";
                    if ("".equals(autowired.value())) {
                        beanName = StringUtils.firstCharToLowerCase(field.getType().getSimpleName());
                    } else {
                        beanName = autowired.value();
                    }

                    Object source = ioc.get(beanName);
                    if (source != null) {
                        field.set(bean, source);
                    }

                }
            }
        } catch (IllegalAccessException e) {
            log.error("ioc����ע��ʧ��",e);
        }
    }

    /**
     * ������ʼ��
     */
    private void scanPackageFile(String scanPackage) {
        URL url = this.getClass().getClassLoader().getResource(scanPackage.replaceAll("\\.", SEPARATOR));
        File file = new File(url.getFile());
        for (File source : file.listFiles()) {
            if (source.isDirectory()) {
                scanPackageFile(scanPackage + "." + source.getName());
            } else {
                if (!source.getName().endsWith(".class")) {
                    continue;
                }

                //������������
                scanClassNames.add(scanPackage + "." + source.getName().replace(".class", ""));

            }
        }
    }

    /**
     * ע��ioc����
     */
    private void doRegistry() {

        try {
            for (String className : scanClassNames) {
                Class<?> clazz = Class.forName(className);
                AnnotationIocStrategy strategy = AnnotationIocFactory.getStrategy(clazz);
                if (strategy != null) {
                    strategy.doRegistry(clazz, ioc);
                }

            }
        } catch (Exception e) {
            log.error("ע��ioc����ʧ��", e);
        }
    }

    /**
     * �������ƻ�ȡ��
     * @param name ����
     * @return Object
     */
    public Object getBeanOfName(String name){
        return ioc.get(name);
    }


}
