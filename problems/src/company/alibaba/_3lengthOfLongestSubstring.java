package company.alibaba;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @Author Zhang Qihang
 * @Date 2022/1/29 17:41
 */
public class _3lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        // 先明确hashmap的定义，存放的是位置，并不是个数
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }

}
