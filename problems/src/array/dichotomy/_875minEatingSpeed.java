package array.dichotomy;

/**
 * @Description 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来
 * @Author Zhang Qihang
 * @Date 2022/1/28 23:02
 */
public class _875minEatingSpeed {
    // 这里并不是对piles进行二分，而是对速度进行二分，相当于区间为[0,K]
    public int minEatingSpeed(int[] piles, int h) {
        int maxVal = 0;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }
        int left = 1, right = maxVal;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, h, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canEatAll(int[] piles, int h, int speed) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + speed - 1) / speed;
        }
        return time <= h;
    }

}
