package pers.chao.springboot.mock.core;

import lombok.extern.slf4j.Slf4j;
import pers.chao.springboot.mock.annotation.SpringBootApplication;
import pers.chao.springboot.mock.config.ApplicationConfiguration;
import pers.chao.springboot.mock.tomcat.TomcatStarter;

import java.io.File;

/**
 * 写点什么吧
 *
 * @author WangYichao
 * @date 2019/4/27 12:37
 */
@Slf4j
public class SpringApplication {

    public static ApplicationContext run(Class<?> targetClass, String... args) {

        ApplicationContext applicationContext = new ApplicationContext();
        try {
            boolean present = targetClass.isAnnotationPresent(SpringBootApplication.class);
            if (!present) {
                throw new RuntimeException("启动类必须含有 @SpringBootApplication 注解");
            }

            //读取配置
            ApplicationConfiguration configuration = new ApplicationConfiguration();
            configuration.loadConfig();

            //构建应用程序上下文
            String scanPackage = targetClass.getPackage().getName();

            applicationContext.init(scanPackage);

            //启动tomcat 构建dispatcherServlet
            TomcatStarter tomcatStarter = new TomcatStarter();

            tomcatStarter.start();
        } catch (Exception e) {
            log.error("Springboot 应用启动失败",e);
        }
        return applicationContext;
    }
}
