package sort;

/**
 * BitMapDeduplication：使用位图对已知范围内的整数进行快速去重。
 * 适用于大规模整数去重，效率极高。
 * 使用字节数组构造了2维的位图，每一行8位，行数=最大值除以8以后+1
 */
public class BitMapDeduplication {
    private byte[] bitMap;

    /**
     * @param maxNumber 需要去重的最大整数值（包含）。
     */
    public BitMapDeduplication(int maxNumber) {
        //右移3为等于计算num / 8
        // 每个byte存8个位
        this.bitMap = new byte[(maxNumber >> 3) + 1];
    }

    /**
     * 添加一个数字到位图中。
     * @param num 要添加的数字。
     * @return 如果之前未出现过（唯一），返回true；否则返回false。
     */
    public boolean add(int num) {
        //右移3为等于计算num / 8，计算这个数应该在字节数组中的第几个位置
        int byteIndex = num >> 3;
        //利用位运算快速计算num % 8，因为当n为2的幂数时 x % n = x & n-1
        int bitIndex = num & 7;
        byte mask = (byte) (1 << bitIndex);
        boolean isNew = (bitMap[byteIndex] & mask) == 0;
        bitMap[byteIndex] |= mask;
        return isNew;
    }

    /**
     * main方法，演示BitMapDeduplication的用法。
     */
    public static void main(String[] args) {
        BitMapDeduplication dedup = new BitMapDeduplication(20);
        int[] arr = {3, 5, 7, 3, 5, 8, 10, 7, 15, 20, 20};
        System.out.println("去重结果：");
        for (int num : arr) {
            if (dedup.add(num)) {
                System.out.print(num + " ");
            }
        }
    }
}
