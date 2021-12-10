package dp;

/**
 * @Description 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * @Author Zhang Qihang
 * @Date 2021/12/10 20:40
 */
public class _416canPartition {
    // 集合中能否找到一个子集，其和为sum/2，可以利用01背包来进行解决
    // 背包要放入的商品（集合里的元素）重量为 元素的数值，价值也为元素的数值
    public boolean canPartition(int[] nums) {
        // 先去掉肯定不合格的条件
        if (nums.length < 2) {  // 数据小于2
            return false;
        }
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        if (sum % 2 == 1) { // 如果总和为奇数
            return false;
        }
        int target = sum / 2;
        //1. dp的下标及其含义 dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，能否使得这些数的和恰好等于 j。
        //2. 递推公式 dp[i][j] = dp[i-1][j](不选择i，也恰好等于j) or dp[i-1][j-nums[i]](选择i，则0~i-1需要恰好等于j-nums[i]) or
        // nums[i] == j,正好只选一个nums[i]就行了
        //3. 初始化，dp[0][nums[0]]为true，其余全为false  dp[i][0]为true(一个数都不选，那么和就恰好为0)
        boolean[][] dp = new boolean[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for (int j = 0; j <= target; j++) {
            dp[0][j] = (j == nums[0]) ? true : false;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                    continue;
                }
                if (j - nums[i] >= 0) {
                    dp[i][j] = dp[i - 1][j - nums[i]] || nums[i] == j;
                    continue;
                }
            }
        }
        return dp[nums.length - 1][target];
    }

    // 一维滚动数组的写法
    public boolean _canPartition(int[] nums) {
        // 先去掉肯定不合格的条件
        if (nums.length < 2) {  // 数据小于2
            return false;
        }
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        if (sum % 2 == 1) { // 如果总和为奇数
            return false;
        }
        int target = sum / 2;
        //1. dp的下标及其含义 dp[j]表示是否存在一些数，使得这些数的和恰好等于 j。
        //2. 递推公式 dp[j] = dp[j](不选择i也恰好等于j) or dp[j-nums[i]](选择i，则0~i-1需要恰好等于j-nums[i]) or
        // nums[i] == j,正好只选一个nums[i]就行了
        //3. 初始化，dp[0][nums[0]]为true，其余全为false
        boolean[] dp = new boolean[target + 1];
        for (int j = 0; j <= target; j++) {
            dp[j] = (j == nums[0]) ? true : false;
        }
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            // 从后向前
            for (int j = target; j >= 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j - nums[i]] || nums[i] == j || dp[j];
                }
            }
        }
        return dp[target];
    }
}
