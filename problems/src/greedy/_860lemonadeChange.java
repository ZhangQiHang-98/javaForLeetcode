package greedy;

import java.util.Arrays;

/**
 * @Description 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * @Author Zhang Qihang
 * @Date 2021/11/24 16:48
 */
public class _860lemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        // 记录每个面值的数量
        int[] count = new int[3];
        Arrays.fill(count, 0);
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                count[0]++;
            } else if (bills[i] == 10) {
                if (count[0] > 0) {
                    count[0]--;
                    count[1]++;
                } else {
                    return false;
                }
            } else if (bills[i] == 20) {
                if (count[1] > 0 && count[0] > 0) {
                    count[1]--;
                    count[0]--;
                    count[2]++;
                } else if (count[0] >= 3) {
                    count[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
