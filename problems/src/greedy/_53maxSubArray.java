package greedy;

/**
 * @className: _53maxSubArray
 * @Description: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author: Zhang Qihang
 * @date: 2021/11/19 10:54
 */
public class _53maxSubArray {

    // 暴力解法：两层循环
    public int maxSubArray1(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            for (int j = i; j < nums.length; j++) {
                count += nums[j];
                if (result < count) {
                    result = count;
                }
            }
        }
        return result;
    }

    // 贪心算法：如果-2，1在一起，计算序列头的时候，一定不会从-2计算，因为[-2,1]一定比[1]小
    // 局部最优：如果当前连续和为负，那么下一个数不管正、负，加上当前连续和一定更小
    // 如果count+nums[i]为负数了，那么就从nums[i+1]重新从零累计
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (result < count) {
                result = count;
            }
            if (count <= 0) {
                count = 0;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        _53maxSubArray test = new _53maxSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(test.maxSubArray1(nums));
    }
}
