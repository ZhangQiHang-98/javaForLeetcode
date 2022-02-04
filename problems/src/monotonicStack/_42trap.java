package monotonicStack;

/**
 * @Description 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @Author Zhang Qihang
 * @Date 2022/1/3 16:55
 */
public class _42trap {
    // 1. 双指针法，按照列来接雨水,时间复杂度为n^2
    // 每一列雨水的高度，取决于，该列 左侧最高的柱子和右侧最高的柱子(包含自己)中最矮的那个柱子的高度。
    public int trap(int[] height) {
        int len = height.length;
        int sum = 0;
        // 遍历每一列，其中第一个和最后一个柱子不接雨水
        for (int i = 0; i < len; i++) {
            if (i == 0 || i == len - 1) {
                continue;
            }
            // 记录当前左右最高柱子
            int rHetight = height[i];
            int lHeight = height[i];
            for (int r = i + 1; r < len; r++) {
                rHetight = height[r] > rHetight ? height[r] : rHetight;
            }
            for (int l = i - 1; l >= 0; l--) {
                lHeight = height[l] > lHeight ? height[l] : lHeight;
            }
            int h = Math.min(rHetight, lHeight) - height[i];
            if (h > 0) {
                sum += h;
            }
        }
        return sum;
    }

    public int _trap(int[] height) {
        int len = height.length;
        int sum = 0;
        //把每一个位置的左边最高高度记录在一个数组上（maxLeft），右边最高高度记录在一个数组上（maxRight）。
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        //1. dp的含义 dp[i]为i左、右侧的最高高度
        //2. 递推公式,leftMax[i]=Math.max(height[i],leftMax[i-1]),从左往右
        //   rightMax=Math.max(height[i],rightMax[i+1])从右往左
        leftMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        rightMax[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        // 遍历每一列，其中第一个和最后一个柱子不接雨水
        for (int i = 0; i < len; i++) {
            if (i == 0 || i == len - 1) {
                continue;
            }
            int h = Math.min(rightMax[i], leftMax[i]) - height[i];
            if (h > 0) {
                sum += h;
            }
        }
        return sum;
    }

}
