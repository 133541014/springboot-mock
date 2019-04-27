package pers.chao.springboot.mock.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 存储配置信息
 *
 * @author WangYichao
 * @date 2019/4/27 12:28
 */
public class ApplicationConfiguration {

    /**
     * 配置文件
     */
    public static Properties properties = new Properties();

    /**
     * 启动端口
     */
    public static int SERVER_PORT = 8080;


    /**
     * 应用上下文路径
     */
    public static String CONTEXT_PATH = "";

    /**
     * 配置文件默认名称
     */
    public static String CONFIG_FILENAME = "application.properties";

    /**
     * 加载classpath下的application.properties配置文件
     */
    public void loadConfig() throws Exception {
        InputStream inputStream = ApplicationConfiguration.class.getClassLoader().getResourceAsStream(CONFIG_FILENAME);
        if (inputStream == null) {
            return;
        }
        properties.load(inputStream);

        Object serverPort = properties.get(PropertiesConstants.SERVER_PORT);
        if (serverPort != null) {
            SERVER_PORT = Integer.valueOf(serverPort.toString());
        }

        Object contextPath = properties.get(PropertiesConstants.SERVER_CONTEXTPATH);
        if (contextPath != null){
            CONTEXT_PATH = contextPath.toString();
        }

        //TODO 加载其他配置
    }
}
