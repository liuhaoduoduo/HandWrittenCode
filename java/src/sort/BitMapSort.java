package sort;
/**
 * 位图排序
 * 用一个bit位来标记某个元素对应的Value。比如将第7位置为1代表7，第1位置为1代表1。
 */
public class BitMapSort {
    public static void main(String[] args) {
        int[] nums = { 1, 4, 7, 5, 6 };
        int max = 7; // 假定最大值已知
        int bitmap = 0;
        // 将每个数字映射到bitmap
        for (int num : nums) {
            bitmap |= (1 << (num - 1));
        }
        // 输出排序后的结果
        for (int i = 0; i < max; i++) {
            if ((bitmap & (1 << i)) != 0) {
                System.out.print((i + 1) + " ");
            }
        }
    }
}
