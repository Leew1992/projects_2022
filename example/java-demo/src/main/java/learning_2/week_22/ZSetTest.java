package learning_2.week_22;

import learning_2.utils.JacksonUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class ZSetTest {
    private static final Integer HASH_COUNT = 100;
    private static final Integer TOP_COUNT = 100;
    private static final Integer DATA_COUNT = 1000;
    private static final String HASH_PREFIX = "HASH_";
    private static final Map<String, List> TOTAL_MAP = new HashMap<>();
    private static final ConcurrentSkipListMap<String, Integer> TOP_MAP;
    private static volatile Integer MIN_VALUE = 0;

    static {
        TOP_MAP = new ConcurrentSkipListMap((Object newObj, Object oldObj) -> {
            Integer firstNewValue = fetchNumber(newObj, "_", 0);
            Integer firstOldValue = fetchNumber(oldObj, "_", 0);
            int firstResult = firstOldValue.compareTo(firstNewValue);
            if (firstResult != 0) {
                return firstResult;
            }
            Integer secondNewValue = fetchNumber(newObj, "_", 2);
            Integer secondOldValue = fetchNumber(oldObj, "_", 2);
            return secondNewValue.compareTo(secondOldValue);
        });

    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        int count = 0;
        while (count <= DATA_COUNT) {
            String key = UUID.randomUUID().toString().replaceAll("-", "").substring(0,10);
            int value = new SecureRandom().nextInt(100);
            updateValue(key, count++, value);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(JacksonUtils.OBJECT_MAPPER.writeValueAsString(TOTAL_MAP.get("HASH_0")));
        System.out.println(JacksonUtils.OBJECT_MAPPER.writeValueAsString(TOP_MAP));
    }

    private static void updateValue(String key, int number, int value) throws Exception {
        if (StringUtils.isEmpty(key)) {
            return;
        }
        int hashValue = key.hashCode() & Integer.MAX_VALUE % HASH_COUNT;
        String hashKey = HASH_PREFIX + hashValue;
        List<Option> optionList = TOTAL_MAP.get(hashKey);
        // 初始化
        if (CollectionUtils.isEmpty(optionList)) {
            synchronized (TOTAL_MAP) {
                if (CollectionUtils.isEmpty(optionList)) {
                    optionList = new ArrayList<>();
                    TOTAL_MAP.put(hashKey, optionList);
                }
            }
        }
        // 赋值
        synchronized (optionList) {
            boolean raise = updateSort(key, number, value);
            if (!raise) {
                optionList.add(new Option(key, value));
            }
        }
    }

    /**
     * 新元素，会替换老元素
     */
    private static boolean updateSort(String key, Integer number, Integer value) throws Exception {
        if (value > MIN_VALUE) {
            synchronized (TOP_MAP) {
                // 新元素
                TOP_MAP.put(value + "_" + key + "_" + number, value);
                if (TOP_MAP.size() <= TOP_COUNT) {
                    // 榜单元素，是否存在对应hash表中
                    updateValue(key, number, value);
                    return true;
                }
                // 老元素
                Map.Entry<String, Integer> lastEntry = TOP_MAP.lastEntry();
                MIN_VALUE = lastEntry.getValue();
                TOP_MAP.remove(lastEntry.getKey());
                // 重新分配
                String realKey = fetchKey(lastEntry.getKey(), "_", 0);
                updateValue(realKey, number, lastEntry.getValue());
                return true;
            }
        }
        return false;
    }

    private static Integer fetchNumber(Object obj, String delimiter, int index) {
        return Integer.valueOf(String.valueOf(obj).split(delimiter)[index]);
    }

    private static String fetchKey(Object obj, String delimiter, int index) {
        String[] split = String.valueOf(obj).split(delimiter);
        index = split.length == 3 ? 1 : 0;
        return split[index];
    }
}
