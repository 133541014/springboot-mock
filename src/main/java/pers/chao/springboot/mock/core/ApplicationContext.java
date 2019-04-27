package pers.chao.springboot.mock.core;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 写点什么吧
 *
 * @author WangYichao
 * @date 2019/4/27 12:38
 */
@Slf4j
public class ApplicationContext {

    /**
     * ioc容器
     */
    public static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    /**
     * 文件系统分隔符
     */
    public static final String SEPARATOR = "/";

    /**
     * 扫描包下完整类名集合
     */
    private List<String> scanClassNames = new ArrayList<>();

    public void init(String scanPackage) {
        scanPackageFile(scanPackage);
        //初始化ioc容器
        initBeans();
        log.info("容器已经初始化");
    }

    /**
     * 容器初始化
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

                //放入完整类名
                scanClassNames.add(scanPackage + "." + source.getName().replace(".class", ""));

            }
        }
    }

    /**
     * 初始化ioc容器
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
