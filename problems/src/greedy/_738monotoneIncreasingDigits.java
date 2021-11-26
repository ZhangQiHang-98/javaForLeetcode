package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Description 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * @Author Zhang Qihang
 * @Date 2021/11/26 22:15
 */
public class _738monotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int n) {
        if (n < 10) {
            return n;
        }
        // 拆分数字
        ArrayList<Integer> nums = new ArrayList<Integer>();
        while (n != 0) {
            nums.add(n % 10);
            n = n / 10;
        }

        Collections.reverse(nums);
        // 自后向前遍历
        for (int i = nums.size() - 1; i >= 1; i--) {
            // 如果当前为递减
            if (nums.get(i) < nums.get(i - 1)) {
                // 当前位置为9，前一位-1
                nums.set(i, 9);
                nums.set(i - 1, nums.get(i - 1) - 1);
            }
        }
        System.out.println(nums);
        return 1;
    }

    public static void main(String[] args) {
        _738monotoneIncreasingDigits test = new _738monotoneIncreasingDigits();
        // 不对
        System.out.println(test.monotoneIncreasingDigits(2129));
    }
}
