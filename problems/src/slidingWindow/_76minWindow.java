package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
 * @Author Zhang Qihang
 * @Date 2022/3/2 11:38
 */
public class _76minWindow<Static> {
    static HashMap<Character, Integer> ht = new HashMap<>();
    static HashMap<Character, Integer> hs = new HashMap<>();

    public static String minWindow(String s, String t) {
        StringBuffer sb = new StringBuffer(s);
        // 将t串先存入
        for (Character c : t.toCharArray()) {
            ht.put(c, ht.getOrDefault(t, 0) + 1);
        }
        int resLen = Integer.MAX_VALUE;
        int start = 0;
        int end = -1;
        int resStart = 0;
        int resEnd = 0;
        while (end < s.length()) {
            end++;
            // 如果end指向的字符存在于ht中
            if (end < s.length() && ht.containsKey(s.charAt(end))) {
                hs.put(s.charAt(end), hs.getOrDefault(s.charAt(end), 0) + 1);
            }
            // 判断一下，如果ok的话
            while (start < end && check()) {
                // 判断当前条件
                if (end - start + 1 < resLen) {
                    resLen = end - start + 1;
                    resStart = start;
                    resEnd = end;
                }
                // 找到成功的之后start往后推
                if (ht.containsKey(s.charAt(start))) {
                    hs.put(s.charAt(start), hs.getOrDefault(s.charAt(start), 0) - 1);
                }
                start++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(resStart, resEnd + 1);
    }

    public static boolean check() {
        for (Character c : ht.keySet()) {
            Integer value = ht.get(c);
            if (hs.getOrDefault(c, 0) < value) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        minWindow("ADOBECODEBANC"
                , "ABC");
    }
}
