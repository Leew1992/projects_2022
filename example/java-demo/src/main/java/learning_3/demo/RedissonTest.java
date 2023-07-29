package learning_3.demo;

import io.reactivex.rxjava3.core.Single;
import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RedissonTest {

    @Autowired
    private RedissonClient redissonClient;

    public String testLock() {
        // 1.获取锁，只要锁的名字一样，获取到的锁就是同一把锁。
        RLock lock = redissonClient.getLock("lock");

        // 2.加锁，如果被别的线程持有，立即失败
        lock.lock(); // 开启看门狗
//        lock.lock(5, TimeUnit.SECONDS); // 不开启看门狗
        try {
            // 尝试获取锁，有效期1秒，最长等待时间10秒
            // boolean flag = lock.tryLock(10, 1, TimeUnit.SECONDS);
            System.out.println(lock.remainTimeToLive());
            System.out.println("加锁成功，执行后续代码。线程 ID：" + Thread.currentThread().getId());
            Thread.sleep(31000);
            System.out.println(lock.remainTimeToLive());
        } catch (Exception e) {
            e.printStackTrace();
            //TODO
        } finally {
            lock.unlock();
            // 3.解锁
            System.out.println("Finally，释放锁成功。线程 ID：" + Thread.currentThread().getId());
        }

        return "test lock ok";
    }

    public void testReadWriteLock() {
        RReadWriteLock rwlock = redissonClient.getReadWriteLock("anyRWLock");
        // 最常见的使用方法
        rwlock.readLock().lock();
        // 或
        rwlock.writeLock().lock();
    }

    public void testSortedSet() {
        RedissonRxClient redissonRxClient = redissonClient.rxJava();
        RScoredSortedSetRx<Object> scoredSortedSet = redissonRxClient.getScoredSortedSet("scoredSortedSet");
        scoredSortedSet.add(1, "aa").toFuture().isDone();
        scoredSortedSet.add(3, "bb").toFuture().isDone();
        scoredSortedSet.add(2, "cc").toFuture().isDone();
        Single<Integer> size = scoredSortedSet.size();
        try {
            System.out.println(size.toFuture().get());
            Single<Collection<Object>> collectionSingle = scoredSortedSet.valueRange(0, -1);
            System.out.println(collectionSingle.toFuture().get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
