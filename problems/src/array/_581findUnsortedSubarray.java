package array;

/**
 * @className: _581findUnsortedSubarray
 * @Description: 最短无序连续子数组
 * @author: Zhang Qihang
 * @date: 2022/3/31 10:31
 */
public class _581findUnsortedSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        // end和start是乱序子数组的起点与终点
        // 从前往后找end，满足递增就记录最大值，不满足就记录逆序的位置
        // 从后往前找start，满足递减记录最小值，不满足就记录逆序的位置
        int len = nums.length;
        int maxVal = nums[0];
        int minVal = nums[len - 1];
        int left = 0;
        // 防止[1,2,3,4]这种情况的出现
        int right = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] >= maxVal) {
                maxVal = nums[i];
            } else {
                right = i;
            }
            if (nums[len - i - 1] <= minVal) {
                minVal = nums[len - i - 1];
            } else {
                left = len - i - 1;
            }
        }
        System.out.println(left + " " + right);
        return right - left + 1;
    }

    public static void main(String[] args) {
        findUnsortedSubarray(new int[]{3,4,1,2,5});
    }
}
