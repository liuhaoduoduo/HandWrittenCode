package leet_code;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 解题思路：
 * 这个题先将输入数组放入一个set中，利用set的天然去重能力来确保输入数字都是不重复的。
 * 因为set遍历时的是无序的，所以遍历时需要检查当前数的前一个数是否在set中存在，如果不存在，说明其是一串连续序列的开头，如果存在说明不是开头，跳过即可。
 * 后续的统计过程就不断的尝试对当前数进行累加，看看累加后的值是否在set中，如果在说明是连续的，继续累加，直到累加后的值不存在。
 * 统计出当前连续序列的长度后，和最大长度进行比较，更新最大长度。
 */
public class LeetCode_128 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int maxLen=0;
        int curLen=0;
        for (int num : numSet) {
            // 只在序列的起点开始计数
            if (!numSet.contains(num - 1)) {
                curLen = 1;
                int currentNum = num;
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    curLen++;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}
