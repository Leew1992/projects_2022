package demo;

import learning_3.demo.RedissonTest;
import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private RedissonTest redissonTest;

    @Test
    void contextLoads() {
    }

    @Test
    public void testRedisson() {
        System.out.println(redissonClient);
    }

    @Test
    public void testLock() {
        redissonTest.testLock();
    }

    @Test
    public void testSortedSet() {
        redissonTest.testSortedSet();
    }
}
