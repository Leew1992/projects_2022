package learning_4.array;

public class _4_FindMedianSortedArrays {
    public static void main(String[] args) {
        int nums1[] = new int[] {};
        int nums2[] = new int[] {1, 2, 3, 4};
        double medianNum = new _4_FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2);
        double medianSortedArrays_1 = new _4_FindMedianSortedArrays().findMedianSortedArrays_1(nums1, nums2);
        double medianSortedArrays_2 = new _4_FindMedianSortedArrays().findMedianSortedArrays_2(nums1, nums2);
        System.out.println(medianNum);
        System.out.println(medianSortedArrays_1);
        System.out.println(medianSortedArrays_2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] firstResult = new int[nums1.length + nums2.length];
        int[] secondResult = null;

        int firstCount = 0;
        int secondCountStart = 0;

        int count1 = 0;
        int count2 = 0;

        while (count1 < nums1.length || count2 < nums2.length) {
            if (count1 == nums1.length) {
                secondResult = nums2;
                secondCountStart = count2;
                break;
            }
            if (count2 == nums2.length) {
                secondResult = nums1;
                secondCountStart = count1;
                break;
            }
            if (nums1[count1] <= nums2[count2]) {
                firstResult[firstCount++] = nums1[count1++];
            } else {
                firstResult[firstCount++] = nums2[count2++];
            }
        }

        int totalCount = nums1.length + nums2.length;
        int mediaNum = totalCount / 2;
        if (totalCount % 2 == 1) {
            if (firstCount > mediaNum) {
                return firstResult[mediaNum];
            } else {
                int diff = mediaNum - firstCount;
                return secondResult[secondCountStart + diff];
            }
        } else {
            if (firstCount > mediaNum ) {
                return (firstResult[mediaNum - 1] + firstResult[mediaNum ]) / 2.0;
            } else if (firstCount == mediaNum){
                return (firstResult[mediaNum - 1] + secondResult[secondCountStart]) / 2.0;
            } else {
                int diff = mediaNum - firstCount;
                return (secondResult[secondCountStart + diff - 1] + secondResult[secondCountStart + diff]) / 2.0;
            }
        }
    }

    public double findMedianSortedArrays_1(int[] nums1, int[] nums2) {
        int[] mergeSortedArrays = mergeSortedArrays(nums1, nums2);
        int length = mergeSortedArrays.length;
        int mediaNum = length / 2;
        if (length % 2 == 1) {
            return mergeSortedArrays[mediaNum];
        } else {
            return (mergeSortedArrays[mediaNum - 1] + mergeSortedArrays[mediaNum]) / 2.0;
        }
    }

    public int[] mergeSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int count = 0;
        int count1 = 0;
        int count2 = 0;

        while (count1 < nums1.length || count2 < nums2.length) {
            if (count1 == nums1.length) {
                result[count++] = nums2[count2++];
                continue;
            }
            if (count2 == nums2.length) {
                result[count++] = nums1[count1++];
                continue;
            }
            if (nums1[count1] <= nums2[count2]) {
                result[count++] = nums1[count1++];
            } else {
                result[count++] = nums2[count2++];
            }
        }
        return result;
    }

    public double findMedianSortedArrays_2(int[] nums1, int[] nums2) {
        int[] medianArrays = getMedianArrays(nums1, nums2);
        int length = nums1.length + nums2.length;
        if (length % 2 == 1) {
            return medianArrays[1];
        } else {
            return (medianArrays[0] + medianArrays[1]) / 2.0;
        }
    }

    public int[] getMedianArrays(int[] nums1, int[] nums2) {
        int medianNum = (nums1.length + nums2.length) / 2;
        int[] medianArrays = new int[2];
        int count1 = 0;
        int count2 = 0;
        while (count1 + count2 <= medianNum) {
            if (count1 == nums1.length) {
                if (count1 + count2 == medianNum - 1) {
                    medianArrays[0] = nums2[count2++];
                    continue;
                }
                if (count1 + count2 == medianNum) {
                    medianArrays[1] = nums2[count2++];
                    break;
                }
                count2++;
                continue;
            }
            if (count2 == nums2.length) {
                if (count1 + count2 == medianNum - 1) {
                    medianArrays[0] = nums1[count1++];
                    continue;
                }
                if (count1 + count2 == medianNum) {
                    medianArrays[1] = nums1[count1++];
                    break;
                }
                count1 ++;
                continue;
            }
            if (nums1[count1] <= nums2[count2]) {
                if (count1 + count2 == medianNum - 1) {
                    medianArrays[0] = nums1[count1++];
                    continue;
                }
                if (count1 + count2 == medianNum) {
                    medianArrays[1] = nums1[count1++];
                    break;
                }
                count1 ++;
            } else {
                if (count1 + count2 == medianNum - 1) {
                    medianArrays[0] = nums2[count2++];
                    continue;
                }
                if (count1 + count2 == medianNum) {
                    medianArrays[1] = nums2[count2++];
                    break;
                }
                count2 ++;
            }
        }
        return medianArrays;
    }

    /*public double getMedianNum(int[] nums1, int[] nums2) {
        // nums1
        if (nums1.length == 0) {
            if (nums2.length % 2 == 1) {
                return nums2[nums2.length/2];
            } else {
                return (nums2[nums2.length/2-1] + nums2[nums2.length/2]) / 2.0;
            }
        }
        // nums2
        if (nums2.length == 0) {
            if (nums1.length % 2 == 1) {
                return nums1[nums1.length/2];
            } else {
                return (nums1[nums1.length/2-1] + nums1[nums1.length/2]) / 2.0;
            }
        }
        // nums1.max < nums2.min
        if (nums1[nums1.length -1] <= nums2[0]) {
            if (nums1.length > nums2.length) {
                int diff = nums1.length - nums2.length;
                if (diff % 2 == 1) {
                    return nums1[diff/2];
                } else {
                    return
                }
            }
        }
        // nums1 < median nums2
        int medianNum1 = nums1[nums1.length/2];
        int medianNum2 = nums2[nums2.length/2];

    }*/
}
