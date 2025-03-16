class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 25, 12, 36, 4, 18, 22, 3, 9, 15, 28 };
        quickSort(0, arr.length - 1, arr);
        // 输出排序后的数组
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
    }

    private static void quickSort(int left, int right, int[] arr) {
        if (left < right) {
            // 分区操作，获取基准点的最终位置
            int pivotIndex = partition(left, right, arr);
            // 递归排序基准点左侧的子数组
            quickSort(left, pivotIndex - 1, arr);
            // 递归排序基准点右侧的子数组
            quickSort(pivotIndex + 1, right, arr);
        }
    }

    private static int partition(int left, int right, int[] arr) {
        // 选择数组第一个元素作为基准点
        int pivot = arr[left];
        int i = left;
        int j = right + 1;

        while (true) {
            // 从左向右找第一个大于等于基准点的元素。一定要先移动指针，否则要么是在第一次比较时撞到基点元素，要么在找到符合条件的元素后指针被移动
            while (arr[++i] < pivot && i != right) {
            }
            // 从右向左找第一个小于等于基准点的元素。同上所述，一定要先移动指针
            while (arr[--j] > pivot && j != left) {
            }

            // 如果指针相遇或交叉，退出循环
            if (i >= j)
                break;
            // 交换元素
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        // 将基准点放到正确的位置，当发生指针相遇或交叉时，j指向的元素一定是小于基点的，所以此时基点要和j交换
        int temp = arr[left];
        arr[left] = arr[j];
        arr[j] = temp;
        return j;
    }
}
