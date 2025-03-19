/**
 * 两数之和问题：从数组中找出相加后等于目标数的两个数（或索引）。这两个数可能存在，可能不存在，还可能存在多个。当出现多个时只返回前两个即可。
 * 解题思路：
 * 第一步：遍历数组，得出数组中元素与目标值的差。
 * 第二步：检查map中是否含有以差值为key的元素，则这个数一定与当前数相加等于目标数。如果没有则将当前数为key，当前数（或索引）为value放到map中
 * 第三步：重复上述两步，直到找到这两个数或循环结束
 * 示例：
 * 1、假设目标数为10，在循环刚开始时map中的元素是空的，从数组的第一个元素开始便利，第一个元素是6，与目标数差值为4。
 * 2、到map中找key为4的元素，结果当时是找不到。此时将6作为key，6作为value放入到map中。
 * 3、假设第二个元素是4，当遍历到4时，计算后与目标差值为6。
 * 4、到map中找key为6的元素，结果发现可以找到。那将map中的数和当前数拼接成一个数组返回即可。
 */
package integration;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //本实现返回的是符合要求的数的下标
    public static int[] twoSum(int[] nums, int target) {
        //创建一个map，用来保存便利过的数
        Map<Integer, Integer> map = new HashMap<>();
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //计算差值
            int complement = target - nums[i];
            //查询map中有没有对应的数，如果有就把对应数的下标和当前下标放到一个数组中返回。
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            //如果没有对应的数，就把当前数和下标放到map中，供后续查询使用。
            map.put(nums[i], i);
        }
        //循环正常结束，说明数组中没有符合要求的数。返回一个兜底逻辑。
        return new int[]{};
    }

    public static void main(String[] args) {
        //待查找的数组，是否有序无所谓
        int[] nums = {3, 14, 8, 27, 10, 19, 5, 22, 6, 11};
        //目标数
        int target = 9;
        //调用算法取得结果
        int[] result = twoSum(nums, target);
        //如果结果中有两个元素说明找到符合要求的数，否则就是未找到
        if (result.length == 2) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No two numbers sum up to the target.");
        }
    }
}
