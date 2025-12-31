package sliding_window;
/**
 * 寻找字符串中最长的不含重复字符的子串。
 * 使用滑动窗口技术，通过两个指针维护一个当前不含重复字符的子串，并动态调整窗口大小以找到最长子串。
 */
public class LongestUniqueSubstring {
    public static String longestUniqueSubstring(String s) {
        int left = 0, right = 0, maxLen = 0, start = 0;
        java.util.Set<Character> set = new java.util.HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            //因为索引是从0开始，所以长度需要加1
            int curLen = right - left + 1;
            if (curLen > maxLen) {
                maxLen = curLen;
                start = left;
            }
            right++;
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String s = "abbcdef";
        System.out.println(longestUniqueSubstring(s)); // 输出: bcdef
    }
}