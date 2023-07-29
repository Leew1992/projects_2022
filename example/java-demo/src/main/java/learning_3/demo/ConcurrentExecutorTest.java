package learning_3.demo;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentExecutorTest {
    private static final ListeningExecutorService executorService;
    public static final int CONCURRENT_COUNT = 64;
    public static final int batchSize = CONCURRENT_COUNT;
    public static final int EXECUTOR_SIZE = 8;
    static {
        executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(EXECUTOR_SIZE));
        MoreExecutors.addDelayedShutdownHook(executorService, 60, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        execute(integers);
    }

    private static <I, O> List<O> execute(final Collection<I> inputs) {
        if (inputs.isEmpty()) {
            return Collections.emptyList();
        }
        // 并发执行
        Collection<ListenableFuture<O>> allFutures = asyncExecute(inputs);
        // 结果归并
        return getResults(allFutures);
    }

    private static <I, O> Collection<ListenableFuture<O>> asyncExecute(final Collection<I> inputs) {
        Collection<ListenableFuture<O>> result = new ArrayList<>(inputs.size());
        for (final I each : inputs) {
            // 异步执行时直接返回结果
            result.add(executorService.submit(() -> (O) each));
        }
        return result;
    }

    private static <O> List<O> getResults(final Collection<ListenableFuture<O>> allFutures) {
        try {
            List<O> result = new LinkedList<>();
            for (ListenableFuture<O> each : allFutures) {
                result.add(each.get());
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}