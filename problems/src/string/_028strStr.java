package string;

public class _028strStr {
    // kmp算法问题
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next, needle);
        // j指的是pattern
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            // 此处的while同理对应着多次回退，不一定是一次回退就可以找到
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) { // 这时说明pattern已经匹配完成了
                return (i - needle.length() + 1);
            }
        }
        return -1;
    }

    // 本next数组就是前缀匹配表
    public void getNext(int[] next, String s) {
        //j指向前缀末尾位置（重要的是j本身也表示i之前最长相等前后缀的长度），i指向后缀末尾位置
        int j = 0;
        next[0] = 0;
        // 从位置1开始才有后缀
        for (int i = 1; i < s.length(); i++) {
            // 比较s[i]与s[j+1]
            // 如果前后缀末尾不匹配，j就要向前回退，看之前next数组的值，与主函数中相同，只要遇到冲突，就回退着看
            // j=0的时候已经回到了初始位置，就没必要再次回退了
            while (j > 0 && s.charAt(i) != s.charAt(j)) {    // 连续回退的过程
                j = next[j - 1];
            }
            // 前后缀末尾匹配，要将j+1
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }
}


