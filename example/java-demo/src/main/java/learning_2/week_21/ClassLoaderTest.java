package learning_2.week_21;

import java.net.URL;

public class ClassLoaderTest {
    public static void main(String[] args) {
        // 启动类加载器（JAVA_HOME/jre/lib）下的部分核心包
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }

        // 扩展类加载器（JAVA_HOME/jre/lib/ext）下的所有扩展包
        // Extension ClassLoader

        // 系统类加载器（ClassPATH/）下的所有jar和class文件
        // App ClassLoader

    }
}
