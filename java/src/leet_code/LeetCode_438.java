package leet_code;
/**
 * 找到字符串中左右字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 解题思路
 * 该题与LeetCode_49题不同，本题是在一个字符串中做子字符串匹配，而LeetCode_49是在字符串数组中寻找相同字母异位的元素。
 * 首先要看本题所使用的测试用例字符串形式，如果是纯字母且大小写一致，则可以利用位图原理。
 * 1、首先创建两个长度为26的数组，分别用来存在两个字符串的字母存在信息。存在的字母对应索引为1，不存在为0.
 * 此处利用了字母是ASCII码的特性，任何字母与其同样大小写的字母a相减，都能得到一个范围在0～25的数值
 * 2、首先遍历模式字符串P，将其中字母存在性标识到其数组中，同时利用本次循环，将待检查字符串对应长度的子串也进行标识。
 * 3、利用Arrays中的比较方法，比较两个字符串是否一致。如果一致说明待匹配字符串头几位就匹配，所以将索引0加入结果集中
 * 4、从模式字符串长度值为起点开始遍历待匹配字符串，先将字母存在性进行标识。然后对本次之前到其中的状态进行消除，这个之前的长度就是模式字符串的长度值
 * 5、完成步骤4操作后，同样适用Arrays中的比较方法，比较两个字符串是否一致。此时如果一致就说明待匹配字符串从当前位置减去模式字符串长度后位置开始的自字符串是符合要求的，所以这个开始位置加入到结果集。这里需要注意由于字符串索引是从0开始，所以要做加1处理。
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_438 {
    public static void main(String[] args) {
        String s = "aaabb";
        String p = "bb";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();

        if (s.length() < p.length()) {
            return result;
        }

        int[] sMap = new int[26];
        int[] pMap = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sMap[s.charAt(i) - 'a']++;
            pMap[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(sMap, pMap)) {
            result.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            sMap[s.charAt(i) - 'a']++;
            sMap[s.charAt(i - p.length()) - 'a']--;

            if (Arrays.equals(sMap, pMap)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}
