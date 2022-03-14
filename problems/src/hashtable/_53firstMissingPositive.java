package hashtable;

/**
 * @Description 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数
 * @Author Zhang Qihang
 * @Date 2022/3/12 14:10
 */
public class _53firstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        // 数组长度为N，那么第一个没有出现的最小正整数一定在[1,N+1]之间
        int n = nums.length;
        // 先把所有负数改为N+1；
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                nums[i] = n + 1;
            }
        }
        // 打上标记
        for (int i = 0; i < n; i++) {
            if (Math.abs(nums[i]) < n) {
                nums[nums[i] - 1] = -nums[nums[i] - 1];
            }
        }
        // 遍历找到第一个正数，输出下标+1
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return -1;
    }
}
