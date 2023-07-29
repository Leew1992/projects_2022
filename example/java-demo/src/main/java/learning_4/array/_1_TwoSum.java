package learning_4.array;

import java.util.*;

public class _1_TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2};
        int target = 3;
        int[] result = new _1_TwoSum().twoSum2(nums, target);
        System.out.println(Arrays.toString(result));
    }

    // 暴力破解法（时间换空间）
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i ++) {
            for (int j = 1; j < nums.length; j ++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    // Hash表法（空间换时间）
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        // 保存因子1和索引
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i ++) {
            Integer another = map.get(target - nums[i]);
            if (another != null) {
                return new int[] {another, i};
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
