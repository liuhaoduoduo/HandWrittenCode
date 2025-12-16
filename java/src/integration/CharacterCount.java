/**
 * 字符统计问题，对于一个字符串，统计出其中不重复的字符数量。
 * 解题思路：本题可利用java中内置的HashSet来进行去重
 */
package integration;

import java.util.HashSet;
import java.util.Set;

public class CharacterCount {
    public static int countUniqueCharacters(String str) {
        // 如果字符串是null或空字符串，直接返回0
        if (str == null || str.isEmpty()) {
            return 0;
        }
        // 存放字符的set集合
        Set<Character> uniqueChars = new HashSet<>();
        // 遍历字符串中的字符
        for (char c : str.toCharArray()) {
            uniqueChars.add(c);
        }
        // 返回数量
        return uniqueChars.size();
    }

    public static void main(String[] args) {
        // 待处理字符串
        String str = "Long live People's Republic of China";
        int count = countUniqueCharacters(str);
        System.out.println("字符串 \"" + str + "\" 中不同字符的个数为: " + count);
    }
}
