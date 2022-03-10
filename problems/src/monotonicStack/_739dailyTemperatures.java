package monotonicStack;

import java.util.Stack;

/**
 * @Description 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * @Author Zhang Qihang
 * @Date 2022/1/3 15:03
 */
public class _739dailyTemperatures {
    // 通常是一维数组，要寻找任一个元素的右边或者左边第一个比自己大或者小的元素的位置，此时我们就要想到可以用单调栈了。
    // 本题就是寻找右边第一个比自己大的元素
    // 单调栈的本质是空间换时间，因为在遍历的过程中需要用一个栈来记录右边第一个比当前元素大的元素，优点是只需要遍历一次。
    // 1.单调栈中存放的是元素下标。
    // 2.单调栈中的从栈头到栈底是递增的
    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        // 推入一个初始值
        stack.push(0);
        int[] waitDays = new int[len];
        for (int i = 1; i < len; i++) {
            //将当前值与栈顶元素比较
            // 如果当前值小于等于栈顶元素，将当前值推入
            if (temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                // 只要栈不为空且当前值大于栈顶元素，就一直弹出
                while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                    waitDays[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                // 把当前的值放到正确的位置
                stack.push(i);
            }
        }
        return waitDays;
    }

    public int[] _dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] waitDays = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (temperatures[j] > temperatures[i]) {
                    waitDays[i] = j - i;
                    break;
                }
            }
        }
        return waitDays;
    }

    public static void main(String[] args) {
        dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}
