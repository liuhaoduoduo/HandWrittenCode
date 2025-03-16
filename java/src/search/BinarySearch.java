package search;

/**
 * 二分查找（BinarySearch），也称为折半查找，
 * 是一种在有序数组中查找特定元素的高效算法。其基本思想是将数组分成两部分，然后根据目标值与中间元素的大小关系，确定目标值可能存在的那一部分，
 * 再继续在该部分中进行查找，不断缩小查找范围，直到找到目标值或确定目标值不存在。
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        // int index = binarySearchByRecursion(arr, 0, arr.length - 1, 11);
        int index = binarySearchByLoop(arr, 11);
        System.out.println("要查找的数在数组中的索引位置为：" + index);
    }

    /**
     * 使用循环来实现二分查找。相比使用迭代的方式，循环避免的了在数组超大时因迭代次数过多导致的栈溢出问题。
     */
    private static int binarySearchByLoop(int[] arr, int objVal) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            // 这样计算中间点可以防止在超大数组状态下的整数溢出风险
            int mid = left + (right - left) / 2;

            if (arr[mid] == objVal) {
                return mid;
            }
            // 确定后续是查左边还是右边，如果中间点大于目标元素则查左半部分，如果小于目标结点则查右半部分。
            // 这里的左右要根据带查找数组的序别而变，这里是升序数组，所以大于查左，小于查右。如果是降序数组，则要相反进行。
            if (arr[mid] < objVal) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 通过递归实现二分查找。通过递归实现虽然逻辑简单明了但是会有一些潜在的风险，不推荐使用。
     * 问题与不足：
     * 递归调用栈深度问题：代码使用了递归方式实现二分查找。虽然递归实现简洁直观，但对于大规模数据，递归调用会导致栈深度增加，可能引发栈溢出错误。相比之下，迭代方式实现的二分查找更节省空间，因为它只使用常数级的额外空间。
     * 整数溢出风险：在计算中间位置 mid 时，使用了 (left + right) / 2。当 left 和 right 都非常大时，left + right
     * 可能会超出 int 类型的表示范围，导致整数溢出。可以使用 left + (right - left) / 2 来避免这个问题。
     * 递归边界条件错误：在递归调用时，当 arr[mid] > objVal，代码使用 return binarySearch(arr, 0, mid,
     * objVal); 这是错误的，应该是 return binarySearch(arr, left, mid - 1, objVal);
     * 因为当前已经确定目标值在左半部分，而左半部分的范围应该是从 left 到 mid - 1。
     * 逻辑冗余：代码中 if (left==right&&arr[left]!=objVal) 这个判断条件是多余的。在正常的二分查找逻辑中，当 left >
     * right 时就可以确定目标值不存在，不需要额外判断 left == right 且元素不等于目标值的情况。
     */
    private static int binarySearchByRecursion(int[] arr, int left, int right, int objVal) {
        // 当左右指针的索引值相等，且指向位置不等于目标值时，说明数组中并不存在要查找的值，直接返回特殊标识：-1
        if (left > right && arr[left] != objVal) {
            return -1;
        }
        // 中间点
        int mid = (left + right) / 2;
        // 如果中间点恰好等于目标，则直接范围。
        if (arr[mid] == objVal) {
            return mid;
        }
        // 确定后续是查左边还是右边，如果中间点大于目标元素则查左半部分，如果小于目标结点则查右半部分。
        // 这里的左右要根据带查找数组的序别而变，这里是升序数组，所以大于查左，小于查右。如果是降序数组，则要相反进行。
        if (arr[mid] > objVal) {
            return binarySearchByRecursion(arr, 0, mid, objVal);
        } else {
            return binarySearchByRecursion(arr, mid + 1, right, objVal);
        }
    }
}
