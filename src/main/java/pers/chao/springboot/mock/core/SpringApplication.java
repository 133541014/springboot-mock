package pers.chao.springboot.mock.core;

import pers.chao.springboot.mock.annotation.SpringBootApplication;
import pers.chao.springboot.mock.config.ApplicationConfiguration;
import pers.chao.springboot.mock.tomcat.TomcatStarter;

import java.io.File;

/**
 * д��ʲô��
 *
 * @author WangYichao
 * @date 2019/4/27 12:37
 */
public class SpringApplication {

    public static ApplicationContext run(Class<?> targetClass, String... args) {

        ApplicationContext applicationContext = new ApplicationContext();
        try {
            boolean present = targetClass.isAnnotationPresent(SpringBootApplication.class);
            if (!present) {
                throw new RuntimeException("��������뺬�� @SpringBootApplication ע��");
            }

            //��ȡ����
            ApplicationConfiguration configuration = new ApplicationConfiguration();
            configuration.loadConfig();

            //����Ӧ�ó���������
            String scanPackage = targetClass.getPackage().getName();

            applicationContext.init(scanPackage);

            //����tomcat ����dispatcherServlet
            TomcatStarter tomcatStarter = new TomcatStarter();
            tomcatStarter.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return applicationContext;
    }
}
