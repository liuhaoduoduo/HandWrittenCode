/**
 * 十进制数转成其他进制数
 * 解题思路：
 * 本代码采用求余后逆取余的思路进行
 * 第一步：将待转换的十进制除以目标进制数后取余数，
 * 第二步：将待转换的十进制数除以目标数制后取商来缩小其自身
 * 第三步：重复第一、二步，直到数除尽。
 * 第四步：逆向取余数（即第一步计算的余数在最后面）后得到结果。
 */
package integration;

public class DecimalToOtherBase {
    //表示数字的字符
    static final String DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // 转换方法
    public static String decimalToBase(int decimalNum, int base) {
        // 非法进制值拦截
        if (base != 2 && base != 8 && base != 16 && base != 36) {
            throw new IllegalArgumentException("Base must be  2/8/16/36");
        }
        //若待转换数值为0则无需计算，直接返回
        if (decimalNum == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        //记录正负属性
        boolean negative = decimalNum < 0;
        //此处取绝对值是为了简化下面的循环控制条件的书写，否则得根据正数和负数写两条相同的计算逻辑。
        //再此之前已经记录了数的正负属性，所以此处取绝对值后不会影响最终计算结果
        decimalNum = Math.abs(decimalNum);
        while (decimalNum > 0) {
            //取余数
            int remainder = decimalNum % base;
            //以余数作为字符索引来取对应的字符。并且使用头插法将每次取到的余数都放置在最前面，以此实现逆取余的效果
            result.insert(0, DIGITS.charAt(remainder));
            //缩小数值
            decimalNum /= base;
        }
        //根据正负属性添加负号
        if (negative) {
            result.insert(0, '-');
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // 待转换的十进制数
        int decimalNum = -255;
        // 目标进制，可选值有2、8、16、36
        int base = 2;
        System.out.printf("十进制数 %d 转换为 %d 进制是: %s%n", decimalNum, base, decimalToBase(decimalNum, base));
    }
}
