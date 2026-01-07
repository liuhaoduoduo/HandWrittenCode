package leet_code;
/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 解题思路
 * 从数组头开始遍历，使用一个指针指向需要插入数的位置。然后遍历数组，如果发现不为0的元素就移动到指针指向的位置。
 * 遍历结束后将指针和数组结尾之间的位置全都用0填充。
 * 扩展解法
 * 如果出题人发难，不再是单纯的数字，而是一个对象，即便是为都是为0，但其中的其他字段（如版本号）不一样。要确保0的顺序。
 * 如果这样出题，就加一个逻辑，将数组中的0取出来放到列表中，然后将这个列表整个拼接到指针和数组末尾之间的位置。  
 */
public class LeetCode_283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);

    }

    public static void moveZeroes(int[] nums) {
        int insertPoint=0;
        for(int num:nums){
            if (num!=0) {
                nums[insertPoint]=num;
                insertPoint++;
            }
        }
        while(insertPoint<nums.length){
            nums[insertPoint]=0;
            insertPoint++;
        }
    }
}