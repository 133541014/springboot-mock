package pers.chao.springboot.mock.tomcat;

import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import pers.chao.springboot.mock.config.ApplicationConfiguration;
import pers.chao.springboot.mock.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author: WangYichao
 * @description:
 * @date: 2019/4/16 22:15
 */
public class TomcatStarter {

    private static final String TEMP_PATH = "e:/tmp/tomcat";

    public void start() throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(ApplicationConfiguration.SERVER_PORT);
        tomcat.setBaseDir(TEMP_PATH);
        tomcat.getHost().setAutoDeploy(false);

        StandardContext context = new StandardContext();
        context.setPath("");
        context.addLifecycleListener(new Tomcat.FixContextListener());
        tomcat.getHost().addChild(context);

        URL url = this.getClass().getClassLoader().getResource("");
        tomcat.addWebapp(ApplicationConfiguration.CONTEXT_PATH, new File(url.getFile()).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();

    }
}
