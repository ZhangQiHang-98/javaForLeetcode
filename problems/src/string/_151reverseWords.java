package string;

import java.util.ArrayList;

public class _151reverseWords {
    public String reverseWords(String s) {
        // 自己写的几个版本都有问题，来学习一下Carl的写法（不使用辅助空间，空间复杂度为O(1)）
        // 1.移除多余空格 2. 整个字符反转  3.每个单词反转

    }

    // 去除首尾空格以及中间多余的空格
    public StringBuffer removeExtraSpaces(String s) {
        int slow = 0, fast = s.length() - 1;
        // 先将前面空格去掉
        while (s.charAt(slow) == ' ') {
            slow++;
        }
        // 将末尾的空格去掉
        while (s.charAt(fast) == ' ') {
            fast--;
        }
        // 此时slow与end都对应了字母
        StringBuffer temp = new StringBuffer();
        while (slow < fast) {
            // 如果当前的字符不为空或者前一个确定的字符不为空（当前可为空可不为空）
            // 前提条件是此时一定不为空了，所以第一次不会去判断后面的条件
            if (s.charAt(slow) != ' ' || temp.charAt(temp.length() - 1) != ' ') {
                temp.append(s.charAt(slow));
            }
            slow++;
        }
        return temp;
    }

    // 反转字符串指定区间[start, end]的字符
    public void reverseString(StringBuffer s, int start, int end) {
        while (start < end) {
            char temp = s.charAt(start);
            s.setCharAt(start, s.charAt(end));
            s.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    // 反转每个单词
    public void reverseEachWord(StringBuffer s) {
        int start = 0, end = 1;
    }
}
