package string;

public class _459repeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        // 枚举的时候只要在[1,n/2]区间内检查是否有符合条件的情况即可。
        //  先查找能被n整除的i
        int n = s.length();
        for (int i = 1; i * 2 <= n; i++) {
            // 开始渐增i,i代表着重复子串的长度
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match == true) {
                    return true;
                }
            }
        }
        return false;
    }
}
