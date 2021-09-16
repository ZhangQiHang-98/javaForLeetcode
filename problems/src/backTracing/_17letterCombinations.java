package backTracing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按任意顺序返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意1不对应任何字母。
 * @Author Zhang Qihang
 * @Date 2021/9/16 22:17
 */
public class _17letterCombinations {
    // 用一个字符串收集，用一个字符数组进行结果的存放
    StringBuffer temp = new StringBuffer();
    List<String> res = new ArrayList<>();
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    // 参数:index表示当前正在遍历哪个数字
    void backTracing(String digits, int index) {
        // 返回条件：到达字符串的最后一个字符
        if (index == digits.length()) {
            res.add(temp.toString());
            return;
        }
        String str = numString[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            //回溯
            backTracing(digits, index + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits==null ||digits.length()==0){
            return res;
        }
        backTracing(digits, 0);
        return res;
    }
}
