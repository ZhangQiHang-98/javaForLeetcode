package array.dichotomy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * @Author Zhang Qihang
 * @Date 2022/1/28 23:15
 */
public class _475findRadius {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int left = 0;
        int right = (int)1e9;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isValid(houses, heaters, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isValid(int[] houses, int[] heaters, int radius) {
        int i = 0;
        int j = 0;
        while (i < houses.length && j < heaters.length) {
            // 如果相减小于radius，说明这个房子在这个半径内都可以暖到，就找下一个房子
            if (Math.abs(houses[i] - heaters[j]) <= radius) {
                i++;
            } else {
                // 否则说明这个取暖器不能暖到这个房子，就找下一个取暖器
                j++;
            }
        }
        // 如果房子遍历完了，也就是i==house.len，说明所有房子都可以暖到，返回true
        return i == houses.length;
    }
}
