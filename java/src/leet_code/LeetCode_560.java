package leet_code;

import java.util.Arrays;

/**
 * 和为K的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * 解题思路
 * 这道题需要用到数组前缀和。
 * 数组的前缀和指的是数组的前N个元素累加之后的和，前缀和常用于快速计算任意区间的和，可以将区间[i,j]的和用preSum[j]−preSum[i−1]（i>0时）来表示，从而将区间求和的时间复杂度从O(n)降低到O(1)。
 * 遍历数组，计算每个位置的前缀和，同时使用一个哈希表来记录每个前缀和出现的次数。
 * 对于每个位置的前缀和preSum，检查哈希表中是否存在前缀和为preSum−k的记录，如果存在，说明从该前缀和位置到当前位置的子数组和为k，将该前缀和出现的次数加到结果中。
 * 最后返回结果。
 */
public class LeetCode_560 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,2,1};
        int k = 3;
        System.out.println(subarraySum(nums, k));
    }
    public static int subarraySum(int[] nums, int k){
        int result = 0;
        // key: 前缀和, value: 该前缀和出现的次数
        java.util.Map<Integer, Integer> preSumCount = new java.util.HashMap<>();
        preSumCount.put(0, 1); // 前缀和为0出现1次，人为添加的边界条件
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            // 检查是否存在前缀和为 preSum - k
            if (preSumCount.containsKey(preSum - k)) {
                result += preSumCount.get(preSum - k);
            }
            preSumCount.put(preSum, preSumCount.getOrDefault(preSum, 0) + 1);
        }
        return result;
    }
}
