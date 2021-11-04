package backTracing;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 给定一个字符串s，将s分割成一些子串，使每个子串都是回文串。
 * @Author Zhang Qihang
 * @Date 2021/11/1 20:55
 */
public class _131partition {

    //结果存储变量
    Deque<String> path = new LinkedList<>();
    List<List<String>> res = new ArrayList<>();


    // 在此处，startIndex就相当于分割线
    void backTracing(String s, int startIndex) {
        // 回溯的终止条件，如果切割线到末尾了，就已经有一个合法的切割组合了
        if (startIndex >= s.length()) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 回溯的逻辑
            // 如果左边的串是回文子串，就继续操作，否则直接后移一个即可
            if (isPalindrome(s, startIndex, i)) {
                path.addLast(s.substring(startIndex, i + 1));
            } else {
                // 如果不是的话就一直往后，直到找到第一个符合的子串。
                continue;
            }
            // 向后切割一位
            backTracing(s, i + 1);
            path.removeLast();
        }
    }

    public List<List<String>> partition(String s) {
        if (s.length() == 0) {
            return res;
        }
        backTracing(s, 0);
        return res;
    }

    // 判断子串是否为回文串
    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String test = "ac";
        System.out.println(test.substring(0, 1));
        System.out.println();
    }
}
