package leet_code;
/**
 * 寻找旋转排序数组中的最小值
 * 已知一个长度为 n 的数组 nums ，它是一个升序排列的数组
 * 在预先未知的某个点上进行了旋转（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 * 解题思路
 * 使用二分查找的方法。
 * 初始化两个指针 left 和 right，分别指向数组的起始和结束位置。
 * 计算中间位置 mid 的值，并比较 nums[mid] 和 nums[right] 的值。
 * 如果 nums[mid] > nums[right]，说明最小值在右半部分，更新 left 为 mid + 1。
 * 否则，最小值在左半部分，更新 right 为 mid。
 * 重复上述过程，直到 left 和 right 收敛到同一个位置，该位置即为最小值所在的位置。
 */
public class LeetCode_153 {
    public static void main(String[] args) {
       int[] nums = new int[]{3,4,5,1,2};
       findMin(nums);
    }
        public static int findMin(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                //此处必须是 left + (right - left) / 2，防止left+right溢出。
                //直接使用(right-left)/2求出的是2个指针的中间距离，不是真正的中位数下标
                //例如，如果 left = 3, right = 7，(right - left) / 2 = (7 - 3) / 2 = 2，但 mid 应该是 3 + 2 = 5
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return nums[left];
    }
}
