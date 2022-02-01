package company.alibaba;

import java.util.Arrays;

/**
 * @Description 给你两个版本号 version1 和 version2 ，请你比较它们。
 * @Author Zhang Qihang
 * @Date 2022/1/31 12:07
 */
public class _165compareVersion {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < v1.length || i < v2.length; i++) {
            int x = 0, y = 0;
            // v1处还有值
            if (i < v1.length) {
                x = Integer.parseInt(v1[i]);
            }
            if (i < v2.length) {
                y = Integer.parseInt(v2[i]);
            }
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
        }
        return 0;
    }

    public int _compareVersion(String version1, String version2) {
        int n = version1.length();
        int m = version2.length();
        // 双指针
        int p1 = 0, p2 = 0;
        while (p1 < n || p2 < m) {
            // 记录当前的数进行比较
            int v1 = 0;
            for (; p1 < n && version1.charAt(p1) != '.'; p1++) {
                v1 = v1 * 10 + version1.charAt(p1) - '0';
            }
            // 跳过.号进行下一次循环
            p1++;

            int v2 = 0;
            for (; p2 < m && version2.charAt(p2) != '.'; p2++) {
                v2 = v2 * 10 + version2.charAt(p2) - '0';
            }
            p2++;

            if (v1 != v2) {
                return v1 > v2 ? 1 : -1;
            }
        }
        return 0;
    }
}
