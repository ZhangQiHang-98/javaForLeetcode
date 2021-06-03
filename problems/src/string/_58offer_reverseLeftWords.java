package string;

public class _58offer_reverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        StringBuffer temp = new StringBuffer();
        temp.append(s.substring(n, s.length()));
        temp.append(s.substring(0, n));
        return temp.toString();
    }
}
