package dichotomy;

import java.util.Arrays;

public class _875minEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        // 思路：枚举所有可能的速度，与piles列表无关，因为每次必须选一堆，堆的前后选择顺序不影响最后吃完的时间
        // 因此，本题的二分解空间应该是速度空间，速度k的空间应该是从[1,max(piles)]，因该选择的是解空间的最左侧可以吃完的速度speed1
        // speed1左边都吃不完，speed1右边都吃得完，因此可以参考最左插入位置
        int left = 1;
        int right = 1_000_000_000;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (helper(piles, middle, h)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    private Boolean helper(int[] piles, int middle, int h) {
        int curTime = 0;
        for (int pile : piles) {
            curTime += (pile + middle - 1) / middle;
        }
        // 小于等于说明等于也要往左移动
        return curTime <= h;
    }
}
