package learning_2.week_19;

import org.springframework.cache.annotation.CacheEvict;

import java.io.FileInputStream;

public class FileInputStreamTest {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("d:/123.txt");
        fis.close();
    }

    @CacheEvict("")
    public void test() {

    }
}
