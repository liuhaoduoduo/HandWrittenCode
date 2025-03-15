/**
 * 冒泡排序
 * 思路：比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 这样，每一次比较都会将最大的元素“沉底”。
 */
class BubbleSort {
    public static void bubbleSort(int[] arr) {
        // 外层循环控制比较的轮数
        for (int i = 0; i < arr.length; i++) {
            // 内层循环控制每一轮比较的次数，每一轮比较后数组的末尾就会成为有序状态，所以每一轮比较的次数都会减少
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换 arr[j+1] 和 arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        System.out.print("排序后的数组: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}