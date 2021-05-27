package string;

public class _541reverseStr {
    public String reverseStr(String s, int k) {
        StringBuffer res = new StringBuffer();
        int length = s.length();
        int start = 0;
        while (start < length) {
            // 找到反转的k和2k处
            StringBuffer temp = new StringBuffer();
            int firstK = (start + k > length) ? length : start + k;
            int secondK = (start + (2 * k) > length) ? length : start + (2 * k);

            temp.append(s.substring(start, firstK));
            res.append(temp.reverse());

            if (firstK < secondK) { //此时剩余长度一定大于k。
                res.append(s.substring(firstK, secondK));
            }
            start += (2 * k);
        }
        return res.toString();
    }
}
