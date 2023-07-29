package learning_1.week_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 两数之和
public class _1_TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = new _1_TwoSum().twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            int ele = target - nums[i];
            if (map.get(ele) != null) {
                result[0] = map.get(ele);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
