package learning_1.week_9;

import sun.misc.ProxyGenerator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public class Test {

    public static void main(String[] args) throws Exception{
        Long a = 3L;
        System.out.println(Optional.ofNullable(a).orElse(0L));

        byte[] bytes = ProxyGenerator.generateProxyClass("aa", new Class[]{UserDao.class});

        Files.write(Paths.get("D:\\WorkSpace\\learning\\src\\main\\java\\week_9\\UserDaoProxy.class"), bytes);
    }
}
