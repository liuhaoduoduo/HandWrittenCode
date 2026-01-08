package leet_code;

/**
 * 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 解题思路
 * 本题依次从数组的头和尾两端对数组进行遍历，遍历到头尾汇合或交叉为止。
 * 遍历时，取两头高度最低的一个边乘以头尾的跨度，计算得出这段区间的面积（木桶原理，装水多少取决于最矮的边）。
 * 每次计算后将当前计算的面积与之前计算的面积相比较，保留其中最大的面积值。
 * 同样基于木桶原理，如果矮边在左，就移动左指针，反之移动右指针。
 * 
 */
public class LeetCode_11 {
    public static void main(String[] args) {
        int[] height = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int temp = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, temp);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
