package learning_2.week_16;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RateLimiterTest {

    static SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss.SSS");

    public static void main(String[] args) throws Exception {
        // testBursty();
        testWarmingUp();
    }

    /**
     * 突发模式
     * @throws Exception
     */
    private static void testBursty() throws Exception {
        System.out.println("____test SmoothBursty____");
        //每秒放10个令牌（QPS=10,0.1s加一个令牌）
        RateLimiter limit = RateLimiter.create(10);
        //等待令牌桶里存放10个令牌（默认最多缓存1s的令牌数）
        Thread.sleep(2000);
        for (int i = 0; i < 20; i++) {
            //等同于acquire(1);阻塞直到获得令牌，返回等待时间（秒），返回0s说明没有等待
            double waitSeconds = limit.acquire();
            System.out.println(i + "_time：" + format.format(new Date()) + "_等待（秒）：" + waitSeconds);
        }
        System.out.println("_________________________");
        for (int i = 0; i < 5; i++) {
            //等同于tryAcquire(1);不阻塞，获取成功返回true；
            System.out.println(format.format(new Date()) + "____" + limit.tryAcquire());
            //其他tryAcquire实际最终都是调用public boolean tryAcquire(int permits, long timeout, TimeUnit unit);带超时等待时间
            Thread.sleep(50);
        }
    }

    /**
     * 预热模式（可以设置预热时间）
     * @throws Exception
     */
    private static void testWarmingUp() throws Exception {
        System.out.println("____test SmoothWarmingUp____");
//		Duration duration = Duration.ofSeconds(2);
//		limit = RateLimiter.create(10, duration);//实际调用create(permitsPerSecond, toNanosSaturated(warmupPeriod), TimeUnit.NANOSECONDS);
        //带600ms的预热时间
        //（即使桶里有10个令牌也不会立马获得10个，需要600ms逐渐加速到可以每0.1s获得一个令牌）
        RateLimiter limit2 = RateLimiter.create(10, 600, TimeUnit.MILLISECONDS);
        // Thread.sleep(2000);//等待令牌桶里存放10个令牌
        for (int i = 0; i < 20; i++) {
            /*if(i == 10) {
                Thread.sleep(600);//再次缓存6个令牌
            }*/
            double waitSeconds = limit2.acquire();//每次阻塞取2个令牌
            System.out.println(i + "_time：" + format.format(new Date()) + "_等待（秒）：" + waitSeconds);
        }
    }
}
