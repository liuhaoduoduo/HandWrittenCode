package sort;
/**
 * 堆排序
 * 堆是一种特殊的完全二叉树，分为大根堆和小根堆。大根堆的每个节点的值都大于或等于其左右子节点的值，小根堆则相反，每个节点的值都小于或等于其左右子节点的值。
 * 堆排序利用堆的性质，将待排序序列构造成一个大根堆（升序排序）或小根堆（降序排序），然后依次取出堆顶元素并调整堆，从而得到有序序列。
 * 步骤
 * 1、建堆，利用扩展知识中的公式，找到最后一个非叶子结点。即使用数组长度除以2后减1即得到最后一个非根结点，然后将该结点和其两个子节点比较，将较大的元素和根做交换。
 * 
 * 扩展知识：
 * 在用数组表示二叉树时，数组索引值之间存在特定的数学关系。
 * 假设树的根节点是0。对于一个任意的非根节点（索引i>0），其父节点的索引为(i-1)/2（这里的除法是整数除法，会自动向下取整）。例如，若一个节点的索引
 * i = 3，那么它父节点的索引为 (3 - 1) / 2 = 1。
 * 左子节点：如果节点 i 存在左子节点，那么左子节点的索引为 2*i+1。比如，节点 i=1 的左子节点索引为 2*1+1=3。
 * 右子节点：如果节点 i 存在右子节点，那么右子节点的索引为 2*i+2。例如，节点 i=1 的右子节点索引为 2*1+2=4。
 * 
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = { 25, 12, 36, 4, 18, 22, 3, 9, 15, 28 };
        heapSort(arr);
        // 输出排序后的数组
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
    }

    private static void heapSort(int[] arr) {
        // 数组规模，在堆排序过程中堆的规模会不断的缩小。
        int n = arr.length;
        // 将原始数组调整为大根堆，循环起始元素元素为第一个非叶子结点，终点为树根结点
        for (int i = (n / 2) - 1; i >= 0; i--) {
            buildHeap(arr, n, i);
        }
        //将堆顶元素与堆最后元素交换，然后缩小堆的规模，重复进行建堆——交换的过程直到结束
        for (int i = n - 1; i > 0; i--) {
            //交换
            int temp = arr[0];
            arr[0]=arr[i];
            arr[i] = temp;
            //建堆
            buildHeap(arr, i, 0);
        }
    }
    //建堆
    private static void buildHeap(int[] arr, int n, int index) {
        // 最大值的索引，初始认为根是最大值
        int largeIndex = index;
        // 左孩子结点索引
        int leftChildIndex = index * 2 + 1;
        // 右孩子索引
        int rightChildIndex = index * 2 + 2;
        // 左孩子的索引，不能大于堆的规模，同时左孩子的值大于当前标定的最大值。下面这两个其实是在找出一个小树中最大的结点
        if (leftChildIndex < n && arr[largeIndex] < arr[leftChildIndex]) {
            largeIndex = leftChildIndex;
        }
        // 右孩子的索引，不能大于堆的规模，同时右孩子的值大于当前标定的最大值
        if (rightChildIndex < n && arr[largeIndex] < arr[rightChildIndex]) {
            largeIndex = rightChildIndex;
        }

        // 如果最大值索引发生改变，则将最大元素交换到当前索引
        if (largeIndex != index) {
            int temp = arr[index];
            arr[index] = arr[largeIndex];
            arr[largeIndex] = temp;
            buildHeap(arr, n, largeIndex);
        }
    }
}