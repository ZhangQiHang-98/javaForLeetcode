package someExample;

/**
 * @Description
 * @Author Zhang Qihang
 * @Date 2022/3/14 14:48
 */
public class test {
    public static String solve (String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        StringBuffer sb = new StringBuffer();
        int cnt = 0;
        int p1 = sarr.length - 1;
        int p2 = tarr.length - 1;

        while(p1 >= 0 || p2 >= 0){
            int v1 = p1 >= 0 ? sarr[p1] - '0' : 0;
            int v2 = p2 >= 0 ? tarr[p2] - '0' : 0;
            int curVal = (v1 + v2 + cnt) % 10;
            cnt = (v1 + v2 + cnt) / 10;
            sb.append((char)(curVal + '0'));
            p1--;
            p2--;
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    public static void main(String[] args) {
        solve("1", "99");
    }
}
