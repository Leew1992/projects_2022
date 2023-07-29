package learning_1.week_1;

// 寻找两个有序数组的中位数
public class _4_FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 3};
        int[] nums2 = new int[] {2};
        double result = new _4_FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // nums1 为空
        if (nums1 == null || nums1.length == 0) {
            return findMedianSingleSortedArrays(nums2);
        }
        // nums2 为空
        if (nums2 == null || nums2.length == 0) {
            return findMedianSingleSortedArrays(nums1);
        }
        // nums1 都小于等于 nums2
        int modValue = (nums1.length + nums2.length) % 2;
        int midLength = (nums1.length + nums2.length) / 2;
        if (nums1[nums1.length-1] <= nums2[0]) {
            return findMedianDoubleOrderedSortedArrays(nums1, nums2, modValue, midLength);
        }

        // nums1 都大于等于 nums2
        if (nums2[nums2.length-1] <= nums1[0]) {
            return findMedianDoubleOrderedSortedArrays(nums2, nums1, modValue, midLength);
        }
        // nums1 nums2 交叉大小
        return findMedianDoubleCrossSortedArrays(nums1, nums2, modValue, midLength);
    }

    // 单数组排序
    private double findMedianSingleSortedArrays(int[] nums) {
        int midLength = nums.length / 2;
        if (nums.length % 2 == 0) {
            return (nums[midLength-1] + nums[midLength]) / 2.0;
        }
        return nums[midLength];
    }

    // 双数组有序排序
    private double findMedianDoubleOrderedSortedArrays(int[] nums1, int[] nums2, int modValue, int midLength) {
        if (modValue == 0) {
            if (midLength > nums1.length) {
                return (nums2[nums2.length-midLength-1] + nums2[nums2.length-midLength]) / 2.0;
            }
            if (midLength == nums1.length) {
                return (nums1[nums1.length-1] + nums2[0]) / 2.0;
            }
            if (midLength < nums1.length) {
                return (nums1[midLength-1] + nums1[midLength]) / 2.0;
            }
        }
        if (modValue == 1) {
            if (midLength > nums1.length) {
                return nums2[nums2.length-midLength-1];
            }
            if (midLength == nums1.length) {
                return nums2[0];
            }
            if (midLength < nums1.length) {
                return nums1[midLength];
            }
        }
        return 0.0;
    }

    // 双数组交叉排序
    private double findMedianDoubleCrossSortedArrays(int[] nums1, int[] nums2, int modValue, int midLength) {
        int count1 = 0, count2 = 0;
        for (int i = 0; i < midLength - 1; i ++) {
            if (count1 == nums1.length) {
                count2 ++;
                continue;
            }
            if (count2 == nums2.length) {
                count1 ++;
                continue;
            }
            if (nums1[count1] <= nums2[count2]) {
                count1 ++;
            } else {
                count2 ++;
            }
        }
        // 溢出选择
        int value1 = 0, value2 = 0;
        if (count1 == nums1.length) {
            value1 = nums2[count2];
            value2 = nums2[count2 + 1];
            return calculateResult(modValue, value1, value2);
        }
        if (count2 == nums2.length) {
            value1 = nums1[count1];
            value2 = nums1[count1 + 1];
            return calculateResult(modValue, value1, value2);
        }
        // 高值选择
        if (nums1[count1] == nums2[count2]) {
            value1 = nums1[count1];
            value2 = nums2[count2];
        }
        if (nums1[count1] < nums2[count2]) {
            value1 = nums1[count1];
            value2 = selectHighValue(count1, count2, nums1.length, nums1, nums2);
        }
        if (nums1[count1] > nums2[count2]) {
            value1 = nums2[count2];
            value2 = selectHighValue(count2, count1, nums2.length, nums2, nums1);
        }
        return calculateResult(modValue, value1, value2);
    }

    // 高值选择
    private int selectHighValue(int countlow, int counthight, int length, int[] numslow, int[] numshigh) {
        if (countlow + 1 < length && numslow[countlow + 1] < numshigh[counthight]) {
            return numslow[countlow + 1];
        }
        return numshigh[counthight];
    }

    // 计算结果
    private double calculateResult(int modValue, int value1, int value2) {
        if (modValue == 0) {
            return (value1 + value2) / 2.0;
        }
        return value2;
    }
}
