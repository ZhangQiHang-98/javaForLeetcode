package string;

public class _344reverseString {
    public void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            s[start] ^= s[end];
            s[end] ^= s[start];
            s[start] ^= s[end];
            start++;
            end--;
        }
    }
}
