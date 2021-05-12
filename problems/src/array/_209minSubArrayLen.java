package array;

public class _209minSubArrayLen {
    // 滑动窗口相关
    public int minSubArrayLen(int target, int[] nums) {
        // 要确定三点
        // 窗口内是什么？ 满足和>=s的长度最小的起始位置
        // 如何移动窗口的起始位置？ 如果当前窗口的值已经满足了，那么就尝试缩小窗口
        // 如何移动窗口的结束位置？窗口的结束位置就是遍历数组的指针，需要一直往后移动到数组的末尾
        int result = nums.length + 1;
        int start = 0; // 滑动窗口起始位置
        int subLength = 0; //滑动窗口的大小
        int sum = 0;    // 滑动窗口中数的和
        for (int j = 0; j < nums.length; j++) { // 首先需要不断地往后移动窗口的结束位置，直到满足条件
            sum += nums[j];
            while (sum >= target) {  // 满足条件之后，再尝试缩小i，直到再次不满足条件位置，在此过程中要比较subLength与result
                subLength = j - start + 1;
                result = result < subLength ? result : subLength;
                sum -= nums[start++];
            }
        }
        return result == nums.length + 1 ? 0 : result;
    }
}
