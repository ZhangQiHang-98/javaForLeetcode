package monotonicStack;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * @Description 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 * @Author Zhang Qihang
 * @Date 2022/3/9 10:56
 */
public class _962maxWidthRamp {


    public static int maxWidthRamp(int[] nums) {
        int len = nums.length;
        // N行2列的情况
        int[][] arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = i;
            arr[i][1] = nums[i];
        }
        Arrays.sort(arr, (o1, o2) -> o1[1] - o2[1]);

        int res = Integer.MIN_VALUE;
        int minIndex = len;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, arr[i][0] - minIndex);
            minIndex = Math.min(minIndex, arr[i][0]);
        }

        return res > 0 ? res : 0;
    }

    // 利用单调栈进行求解
    public static int _maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        // 进行逆序计算
        for (int i = nums.length - 1; i >= 0; i--) {
            // 形成了以stack.peek()的最大坡
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                res = Math.max(i - stack.peek(), res);
                stack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        maxWidthRamp(nums);
    }
}
