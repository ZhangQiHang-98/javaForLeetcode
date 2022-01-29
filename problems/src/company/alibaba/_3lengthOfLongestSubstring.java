package company.alibaba;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @Author Zhang Qihang
 * @Date 2022/1/29 17:41
 */
public class _3lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 做题的时候一定要先想清楚透彻
        // 使用滑动窗口进行解决 同时利用哈希表
        // r 指针不停向右移动，l 指针仅仅在窗口满足条件之后才会移动，起到窗口收缩的效果
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int result = 0;
        // 遍历快指针
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            // 存的是第一次遇到这个字符串时候的位置，所以要先考虑清楚哈希表中应该存放什么
            map.put(s.charAt(right), right);
        }
        return result;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("dvdf");
    }
}
