package leet_code;
/**
 * 三数之和问题
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 解题思路
 * 1、先将数组排序，这样才能通过一次遍历进行查找。否则只能多次遍历。
 * 2、创建一个循环，从数组左侧开始遍历元素，结束条件遍历到数组末尾的第三个数（因为还有两个数要通过指针获取）
 * 3、创建左右两个指针，左指针比步骤2中的循环更进一步，右指针从数组的最右侧开始。
 * 4、指针移动过程中要时刻检查下一个位置的数和当前位置的数是否相等，如果相等就多移动一位。
 * 5、检查三个指针相加的结果，如果满足等于0的条件就记录。如果结果小于0，说明最左侧指针的数太小了，无法满足，需要向右继续寻找；如果大于0说明右边的数太大了，无法满足，需要向左继续寻找；此处因为已经排序了，所以很好确定这个数是否应该抛弃。
 * 
 */
import java.util.*;

public class LeetCode_15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 跳过重复
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++; // 跳过重复
                    while (left < right && nums[right] == nums[right - 1]) right--; // 跳过重复
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}