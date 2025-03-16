/**
 * 手工替换字符
 * 思路：逐个遍历原始字符串，比对是否与指定的字符相等，若相等则用替换字符替代，如果不等则保留原始字符串中的字符
 */
class ManualReplace {
    public static void main(String[] args) {
        String original = "Long live People's Republic of China";
        char pattern = ' ';
        String replace = "-";
        String newString = manualReplace(original, pattern, replace);
        System.out.println("新字符串为：" + newString);
    }

    private static String manualReplace(String original, char pattern, String replace) {
        // 原始字符串或模式为空时无需替换，直接返回原始字符串即可
        if (original == null || replace == null) {
            return original;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            // 如果原始字符串当前位置等于模式，则抛弃这个位置的字符，直接将替换字符压到新字符串中。
            // 如果不等于则将原始字符串当前位置的字符压进新字符串中
            if (original.charAt(i) == pattern) {
                sb.append(replace);
            } else {
                sb.append(original.charAt(i));
            }
        }

        return sb.toString();

    }
}