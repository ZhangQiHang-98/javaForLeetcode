package array;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class _76minWindow {
    public String minWindow(String s, String t) {

        int start = 0;
        String res = "";
        int count = 0;  // 目前一共找到了多少个字符
        int minLength = s.length() + 1; // 最少需要多少个字符

        //用来统计t中每个字符出现次数
        int[] needs = new int[128];
        //用来统计滑动窗口中每个字符出现次数
        int[] window = new int[128];

        for (char c : t.toCharArray()) {
            needs[c]++;
        }

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            // 因为是先添加的window，所以要>=window
            window[ch]++;
            // 如果需要该字符，并且已有窗口内的字符个数 小于需要的字符个数
            if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                count++;    // 匹配到的字符+1
            }

            while (count == t.length()) {  // 当需要的字符都已经包含在窗口中后，开始收缩 left
                if (end - start + 1 < minLength) {  // 比较当前子串和记录的子串的长度关系
                    minLength = end - start + 1;
                    res = s.substring(start, end + 1);
                }
                ch = s.charAt(start);
                if (needs[ch] > 0 && needs[ch] >= window[ch]) { //只有删掉的这个是需要的字符的时候count才--，否则会一直删除下去
                    count--;
                }
                start++;
                // window中的该数-1
                window[ch]--;
            }
        }
        return res;
    }

}
