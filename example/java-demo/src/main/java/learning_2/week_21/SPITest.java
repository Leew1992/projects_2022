package learning_2.week_21;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ServiceLoader;

public class SPITest {
    public static void main(String[] args) {
        testJavaSPI();
        // testDubboSPI();
    }

    /**
     * 不能实现按需加载，需要遍历，找到需要的实现类
     * 没有命名区分，不方便使用
     * 没有使用缓存，每次都重新加载
     */
    private static void testJavaSPI() {
        ServiceLoader<SPIInterface> load = ServiceLoader.load(SPIInterface.class);
        /*for (SPIInterface spiInterface : load) {øo
            spiInterface.test();
        }*/
        if (load.iterator().hasNext()) {
            SPIInterface next = load.iterator().next();
            next.test();
        }
    }

    /**
     * 可以实现按需加载
     * 有命名区分
     * 有使用缓存
     * 需要使用@SPI注解
     */
    private static void testDubboSPI() {
        ExtensionLoader<SPIInterface> loader = ExtensionLoader.getExtensionLoader(SPIInterface.class);
        SPIInterface impl = loader.getExtension("SPI_IMPL");
        impl.test();
        SPIInterface impl2 = loader.getExtension("SPI_IMPL_2");
        impl2.test();
    }

    private void test() throws Exception {
        Connection connection = DriverManager.getConnection("xxx");
        PreparedStatement preparedStatement = connection.prepareStatement("");
        boolean execute = preparedStatement.execute();
    }
}
