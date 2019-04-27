package pers.chao.springboot.mock.core;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * д��ʲô��
 *
 * @author WangYichao
 * @date 2019/4/27 12:38
 */
@Slf4j
public class ApplicationContext {

    /**
     * ioc����
     */
    public static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    /**
     * �ļ�ϵͳ�ָ���
     */
    public static final String SEPARATOR = "/";

    /**
     * ɨ�����������������
     */
    private List<String> scanClassNames = new ArrayList<>();

    public void init(String scanPackage) {
        scanPackageFile(scanPackage);
        //��ʼ��ioc����
        initBeans();
        log.info("�����Ѿ���ʼ��");
    }

    /**
     * ������ʼ��
     */
    public void scanPackageFile(String scanPackage) {
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
     * ��ʼ��ioc����
     */
    private void initBeans() {

        try {
            for (String className : scanClassNames) {
                Class.forName(className);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
