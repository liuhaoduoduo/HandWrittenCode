package dynamic_programming;

/**
 * 给定一个整数数组，每个元素表示一天与前一天相比的带宽变化（负数表示减少，正数表示增加）。编写程序找到带宽变化量总和最大的连续时间段，返回日期区间和最大值。
 * 例如：{ -2, 1, -3, 4, -1, 2, 1, -5, 4 }
 * 此题默认为统计增加最多的
 */
public class Kadane {
    public static void main(String[] args) {
        int[] changes = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int max = changes[0];
        int base_start = 0;
        int base_end = 0;
        int cur_start = 0;
        int cur_end = 0;
        int cur_sum = 0;
        for (int i = 0; i < changes.length; i++) {
            // 如果当前已经统计的区间累加值小于当前节点，说明从当前节点往后的内容有可能大于之前累加的值，此处要重新开始统计一个新的周期。
            // 如果题目中要求找出下降最多的区间，此处就需要将判断条件反过来，
            if (cur_sum < changes[i]) {
                cur_start = i;
                cur_sum = changes[i];
            } else {
                cur_sum += changes[i];
            }
            cur_end = i;
            // 如果当前累加的值已经大于根基的值则需要更新根基的记录数据
            // 此处条件取决于题意，如果提议要求计算下降最多就需要修改判断条件
            if (cur_sum > max) {
                max = cur_sum;
                base_start = cur_start;
                base_end = cur_end;
            }
        }
        System.out.println(String.format("最大的增加区间是自%s天开始至%s天结束，一共减少了%s个带宽", base_start + 1, base_end + 1, max));
    }

}
