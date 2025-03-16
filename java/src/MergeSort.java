/**
 * 归并排序
 * 基本思想
 * 将一个数组分成两个子数组，对每个子数组进行排序，然后将排好序的子数组合并成一个最终的有序数组。这个过程是递归进行的，直到子数组的长度为 1，因为长度为 1
 * 的数组是天然有序的。
 * 算法步骤
 * 分解：将待排序数组不断地分成两半，直到每个子数组只有一个元素。可以使用递归实现这一过程。
 * 合并：将两个已排序的子数组合并成一个更大的已排序数组。合并过程中，通过比较两个子数组的元素，将较小的元素依次放入结果数组中。
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = { 25, 12, 36, 4, 18, 22, 3, 9, 15, 28 };
        margeSort(arr);
        // 输出排序后的数组
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
    }

    private static void margeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        // 用于后续合并操作的临时数组
        int[] temp = new int[arr.length];
        split(arr, 0, arr.length - 1, temp);
    }

    /**
     * 数组切分
     * 
     * @param arr   待切分数组
     * @param left  数组左索引
     * @param right 数组右索引
     * @param temp  用于合并操作的临时数组
     */
    private static void split(int[] arr, int left, int right, int[] temp) {
        // 数组长度不为1时，左右索引一定是左小右大
        if (left < right) {
            // 中间切分点
            int mid = (left + right) / 2;
            split(arr, left, mid, temp);
            split(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 左半数组的左起点
        int i = left;
        // 右半数组的左起点
        int j = mid + 1;
        int tempIndex=0;
        //合并切分数组
        while (i <= mid && j <= right) {
            if (arr[i]>arr[j]) {
                temp[tempIndex++] = arr[j++];
            }else{
                temp[tempIndex++] = arr[i++];
            }
        }
        //将左半部分未合并完的部分合并进临时数组
        while (i<=mid) {
            temp[tempIndex++] = arr[i++];
        }

        //将右半部分未合并完的部分合并进临时数组
        while (j<=right) {
            temp[tempIndex++] = arr[j++];
        }

        //将临时数组排好序的部分替换回原始数组
        tempIndex=0;
        while (left<=right) {
            arr[left++]=temp[tempIndex++];
        }
    }

}
