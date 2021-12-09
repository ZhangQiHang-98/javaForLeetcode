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
        // 要注意的是，从哪一位开始，到之后统一改为9
        if (n < 10) {
            return n;
        }

        // 拆分数字
        ArrayList<Integer> nums = new ArrayList<Integer>();
        while (n != 0) {
            nums.add(n % 10);
            n = n / 10;
        }
        int flag = nums.size();
        Collections.reverse(nums);
        // 自后向前遍历
        for (int i = nums.size() - 1; i >= 1; i--) {
            // 如果当前为递减
            if (nums.get(i) < nums.get(i - 1)) {
                // 当前位置应该为9，前一位-1
                flag = i;
                nums.set(i - 1, nums.get(i - 1) - 1);
            }
        }
        for (int i = flag; i < nums.size(); i++) {
            nums.set(i, 9);
        }
        int result = 0;
        // 拼起来
        for (int i = 0; i < nums.size(); i++) {
            result = result * 10 + nums.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        _738monotoneIncreasingDigits test = new _738monotoneIncreasingDigits();
        System.out.println(test.monotoneIncreasingDigits(2129));
    }
}
