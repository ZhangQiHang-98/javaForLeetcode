package dp;

/**
 * @className: _213rob
 * @Description: 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。第一个和最后一个屋子是环绕的
 * @author: Zhang Qihang
 * @date: 2021/12/17 16:44
 */
public class _213rob {
    public static int helper(int[] nums) {
        //1. dp[i]表示考虑[0..i]个房间后能偷到的最大金额
        //2. 考虑偷不偷第i间房，如果偷 那么dp[i] = dp[i-2]+nums[i] 如果不偷，那么dp[i]=dp[i-1]，取两者之间的最大值
        //3. dp初始化
        int[] dp = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public int rob(int[] nums) {
        //一共有四种情况，头尾都偷、头尾偷一个、头尾一个不偷，第一个不成立，最后一个结果肯定没有第二、三个高
        // 所以考虑头尾选择一个偷
        int[] former = new int[nums.length - 1];
        int[] latter = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            former[i] = nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            latter[i - 1] = nums[i];
        }
        return Math.max(helper(former), helper(latter));
    }
}
