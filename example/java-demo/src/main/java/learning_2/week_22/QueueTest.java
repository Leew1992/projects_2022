package learning_2.week_22;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class QueueTest {
    private static final PriorityBlockingQueue<Option> TOP_QUEUE;

    static {
        /**
         * 只能保证第一个元素（队头）是最大的，如果小于第一个元素（队头），则会被放到最后一个（队尾）。
         */
        TOP_QUEUE = new PriorityBlockingQueue(20, (Object newObj, Object oldObj) -> {
            Option newOp = (Option) newObj;
            Option oldOp = (Option) oldObj;
            if (oldObj == null || newOp == null) {
                return 0;
            }
            if (oldOp.value.intValue() > newOp.value) {
                return -1;
            }
            if (oldOp.value.intValue() < newOp.value) {
                return 1;
            }
            return 0;
        });
    }

    public static void main(String[] args) throws Exception {
        // test();
        /*TOP_QUEUE.offer(new Option("a", 1));
        TOP_QUEUE.offer(new Option("b", 65));
        TOP_QUEUE.offer(new Option("c", 61));
        TOP_QUEUE.offer(new Option("d", 68));
        TOP_QUEUE.offer(new Option("d", 95));
        TOP_QUEUE.offer(new Option("d", 85));
        TOP_QUEUE.offer(new Option("d", 88));
        System.out.println(JacksonUtils.OBJECT_MAPPER.writeValueAsString(TOP_QUEUE));*/

        LinkedBlockingQueue queue = new LinkedBlockingQueue();
        queue.add(1);
        queue.add(2);
        System.out.println(queue);

        Map map = new LinkedHashMap();
        map.put("a", 1);
        map.put("b", 2);
        System.out.println(map);
    }

    private static void test() {
        PriorityQueue queue = new PriorityQueue();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.peek());
    }

    private static void test2() {
        PriorityBlockingQueue<Object> queue = new PriorityBlockingQueue<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.peek());
    }
}
