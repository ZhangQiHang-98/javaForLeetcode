package company.alibaba;

/**
 * @Description 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * @Author Zhang Qihang
 * @Date 2022/2/1 23:50
 */
public class _415addStrings {
    public static String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        // 不要用char数组 还是用StringBuilder
        StringBuilder ans = new StringBuilder();
        int p1 = len1 - 1, p2 = len2 - 1, cnt = 0;
        // 统一往前面添0比较好，否则要考虑的特殊情况太多了
        // cnt不等于0用于进位的情况，比如5+5,这样正好多出来一维
        while (p1 >= 0 || p2 >= 0 || cnt != 0) {
            int v1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int v2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            int result = v1 + v2 + cnt;
            ans.append(result % 10);
            cnt = result / 10;
            p1--;
            p2--;
        }
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("456", "77"));
    }
}
