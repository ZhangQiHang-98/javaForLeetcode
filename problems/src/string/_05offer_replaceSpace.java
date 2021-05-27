package string;

public class _05offer_replaceSpace {
    public String replaceSpace(String s) {
        StringBuffer res = new StringBuffer();
        for (Character c : s.toCharArray()) {
            if (c == ' ') {
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
