package string;

import java.util.ArrayList;

/**
 * @Description
 * @Author Zhang Qihang
 * @Date 2022/3/8 21:43
 */
public class _165version {
    public static int compare (String version1, String version2) {
        // write code here
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int p1 = 0;
        int p2 = 0;
        while(p1 < v1.length || p2 < v2.length){
            int val1 = 0;
            int val2 = 0;
            if(p1 < v1.length){
                val1 = Integer.parseInt(v1[p1]);
            }
            if(p2 < v2.length){
                val2 = Integer.parseInt(v2[p2]);
            }
            if(val1 > val2){
                return 1;
            }
            if(val1 < val2){
                return -1;
            }
            p1++;
            p2++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compare("1.1","0.1"));
        ArrayList<Integer> a = new ArrayList<>();
        a.toArray();
    }
}
