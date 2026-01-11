package leet_code;
/**
 * 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * 解题思路
 * 使用双端队列（Deque）来存储当前窗口内的元素索引
 * 遍历数组，对于每个元素执行以下操作：
 * 1. 移除队首不在窗口内的元素索引
 * 2. 移除队尾比当前元素小的元素索引
 * 3. 将当前元素索引加入队尾
 * 4. 如果当前索引大于等于 k - 1，记录窗口的最大值（即队首元素对应的值）
 * 最后返回结果数组
 */
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode_239 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        int k = 3;
        maxSlidingWindow(nums, k);
    }
    public static int[] maxSlidingWindow(int[] nums, int k){
        if (nums == null || k <= 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < n; i++) {
            // 移除队首不在窗口内的元素
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // 移除队尾比当前元素小的元素
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // 当前元素下标加入队尾
            deque.offerLast(i);
            // 记录窗口最大值
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
