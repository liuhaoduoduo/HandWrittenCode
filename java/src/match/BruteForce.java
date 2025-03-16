package match;
/**
 * 暴力查找
 * 从主字符串的第一个字符开始，依次与模式字符串的字符进行比较。
 * 如果在比较过程中发现字符不匹配，则将匹配起始位后移动一位，从主字符串的下一个字符开始重新进行比较，
 * 直到找到匹配的子串或者查到主字符串的长度减去模式字符串长度的位置为止。
 */
class BruteForce {
    public static void main(String[] args) {
        String original = "Long live People's Republic of China";
        String pattern = "China";
        int index = bruteForce(original, pattern);
        System.out.println("找到子串，起始位置为：" + index);
    }

    private static int bruteForce(String original, String pattern) {
        if (original == null || pattern == null
                || original.length() < pattern.length()
                || original.isEmpty() || pattern.isEmpty()) {
            return -1;
        }
        // 原始字符串长度
        int originalStrLen = original.length();
        // 模式字符串长度
        int patternStrLen = pattern.length();
        // 外层循环，控制原始字符串的比对位置。只比对到原始长度减去模式串长度即可
        for (int i = 0; i <= originalStrLen - patternStrLen; i++) {
            int j = 0;
            // 内层循环控制模式串的比对位置，需要一直比对到模式字符串的末尾
            for (; j < patternStrLen; j++) {
                // 当发现存在不一致时，就可以直接退出本轮比较了
                if (original.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            //如果内循环是正常结束，说明找到了匹配的子串。直接返回索引位置即可
            if (j==patternStrLen) {
                return i;    
            }
            
        }
        // 兜底逻辑，未找到时返回特殊标识：-1
        return -1;

    }
}