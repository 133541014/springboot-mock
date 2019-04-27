package pers.chao.springboot.mock.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * �洢������Ϣ
 *
 * @author WangYichao
 * @date 2019/4/27 12:28
 */
public class ApplicationConfiguration {

    /**
     * �����ļ�
     */
    public static Properties properties = new Properties();

    /**
     * �����˿�
     */
    public static int SERVER_PORT = 8080;


    /**
     * Ӧ��������·��
     */
    public static String CONTEXT_PATH = "";

    /**
     * �����ļ�Ĭ������
     */
    public static String CONFIG_FILENAME = "application.properties";

    /**
     * ����classpath�µ�application.properties�����ļ�
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

        //TODO ������������
    }
}
