package company.microsoft;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Description 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * @Author Zhang Qihang
 * @Date 2022/1/17 15:00
 */
public class groupAnagrams {
    // 注意考虑空字符串的情况
    public List<List<String>> groupAnagrams(String[] strs) {
        // 创建哈希表
        Map<String, List<String>> hash = new HashMap<>();
        // 遍历字符串数组，先得到其排序值
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            // 找到返回对应value，找不到就返回给定的默认值
            List<String> val = hash.getOrDefault(sortStr, new ArrayList<>());
            System.out.println(val);
            System.out.println(str);
            val.add(str);
            hash.put(sortStr, val);
        }
        return new ArrayList<>(hash.values());
    }

    public static void main(String[] args) {

    }
}
