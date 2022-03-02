package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * @Author Zhang Qihang
 * @Date 2022/3/2 10:49
 */
public class _30findSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        int wordCount = words[0].length();
        int wordNum = words.length;
        int allLen = wordCount * wordNum;
        int sLen = s.length();
        HashMap<String, Integer> map = new HashMap<>();
        // 将单词存入map中
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < s.length() - allLen + 1; i++) {
            String temp = s.substring(i, i + allLen);
            HashMap<String, Integer> tmp_map = new HashMap<>();
            for (int j = 0; j < allLen; j += wordCount) {
                String w = temp.substring(j, j + wordCount);
                tmp_map.put(w,tmp_map.getOrDefault(w,0)+1);
            }
            if (map.equals(tmp_map)) res.add(i);
        }
        return res;
    }
}
