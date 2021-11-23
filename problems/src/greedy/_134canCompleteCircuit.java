package greedy;

/**
 * @className: _134canCompleteCircuit
 * @Description: 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * @author: Zhang Qihang
 * @date: 2021/11/23 11:09
 */
public class _134canCompleteCircuit {
    // 暴力解法，循环指定每个起点
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] save = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            save[i] = gas[i] - cost[i];
        }

        // 每个起点
        for (int i = 0; i < gas.length; i++) {
            if (save[i] < 0) {
                continue;
            }
            // 从该位置开始，如果再返回，就可以
            int curIndex = i;
            int count = 0;
            int curGas = 0;
            // 当没走完一圈的时候
            while (count < gas.length) {
                curGas += save[curIndex];
                if (curGas < 0) {
                    break;
                }
                count++;
                curIndex = (curIndex + 1) % gas.length;
            }
            if (count == gas.length) {
                return i;
            }
        }
        return -1;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) { // 如果当前累加值<0，说明已经走不了了
                start = i + 1;
                curSum = 0;
            }
        }
        if (totalSum < 0) {
            return -1;
        }
        return start;
    }
}
