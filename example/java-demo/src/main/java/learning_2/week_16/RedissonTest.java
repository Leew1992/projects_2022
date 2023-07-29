package learning_2.week_16;

import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

// @Component
public class RedissonTest {

    @Autowired
    private static RedissonConfig redissonConfig;

    public static void main(String[] args) {

    }

    private static void testRedission() {
        RedissonClient stringClient = redissonConfig.getStringClient();
        RLock aa = stringClient.getLock("aa");
        RedissonRedLock redissonRedLock = new RedissonRedLock(aa);

        redissonRedLock.lock();
        redissonRedLock.unlock();



    }
}
