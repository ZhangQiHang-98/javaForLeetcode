package greedy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Description 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * @Author Zhang Qihang
 * @Date 2021/11/26 19:33
 */
public class _763partitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new LinkedList<>();
        // edge为各字符出现的最远位置
        int[] edge = new int[27];
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i] - 'a'] = i;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < chars.length; i++) {
            right = Math.max(right, edge[chars[i] - 'a']); // 当前最远边界
            if (i == right) {
                list.add(right - left + 1);
                left = i + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        _763partitionLabels test = new _763partitionLabels();
        test.partitionLabels("ababcbacadefegdehijhklij");
    }
}
