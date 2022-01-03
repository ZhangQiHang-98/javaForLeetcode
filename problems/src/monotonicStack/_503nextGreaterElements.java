package monotonicStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * @Author Zhang Qihang
 * @Date 2022/1/3 16:19
 */
public class _503nextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        // 将两个数组拼接起来即可
        int len = nums.length;
        int[] splice = new int[2 * len];
        for (int i = 0; i < len; i++) {
            splice[i] = nums[i];
            splice[i + len] = nums[i];
        }

        Stack<Integer> st = new Stack<>();
        int[] res = new int[2 * len];
        Arrays.fill(res,-1);
        for (int i = 0; i < 2 * len; i++) {
            while (!st.empty() && splice[i] > splice[st.peek()]) {
                res[st.peek()] = splice[i];
                st.pop();
            }
            st.push(i);
        }
        return Arrays.copyOfRange(res,0,len);
    }
}
