package company.alibaba;

import java.util.Stack;

/**
 * @Description 接雨水问题
 * @Author Zhang Qihang
 * @Date 2022/2/4 21:07
 */
public class _42trap {
    // 首先明确，怎么接，是按照行来接还是按照列来接，我们先按照列来接。
    // 这时，每一列的雨水数等于其左右两侧的最高柱中的较低的柱子-自身高度，注意第一个柱子和最后一个柱子不接雨水(左右会漏)
    public int trap(int[] height) {
        int len = height.length;
        int res = 0;
        if (len <= 2) {
            return 0;
        }
        for (int i = 1; i < len - 1; i++) {
            // 左右指针
            int leftHeight = height[i];
            int rightHeight = height[i];

            //找左侧的最高值
            for (int l = i - 1; l >= 0; l--) {
                leftHeight = height[l] > leftHeight ? height[l] : leftHeight;
            }
            // 找右侧的最高值
            for (int r = i + 1; r < len; r++) {
                rightHeight = height[r] > rightHeight ? height[r] : rightHeight;
            }
            int h = Math.min(leftHeight, rightHeight) - height[i];
            if (h >= 0) {
                res += h;
            }
        }
        return res;
    }

    // 动态规划写法
    // 注意的是，左侧右侧也包括自己
    public int _trap(int[] height) {
        int len = height.length;
        int sum = 0;
        //把每一个位置的左边最高高度记录在一个数组上（maxLeft），右边最高高度记录在一个数组上（maxRight）。
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        //1. dp的含义 dp[i]为i左、右侧的最高高度
        //2. 递推公式,leftMax[i]=Math.max(height[i],leftMax[i-1]),从左往右
        //   rightMax=Math.max(height[i],rightMax[i+1])从右往左
        leftMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        rightMax[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        // 遍历每一列，其中第一个和最后一个柱子不接雨水
        for (int i = 0; i < len; i++) {
            if (i == 0 || i == len - 1) {
                continue;
            }
            int h = Math.min(rightMax[i], leftMax[i]) - height[i];
            if (h > 0) {
                sum += h;
            }
        }
        return sum;
    }

    // 如果是单调栈的话，就是按照行来
    // 当后面的柱子高度比前面的低时，是无法接雨水的，因此要找比当前栈顶大的
    public int __trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int res = 0;
        // 常用模板
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            //栈顶和栈顶的下一个元素以及要入栈的三个元素来接水！
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                // 当前的栈顶元素就是凹槽的底部，也就是中间位置
                int mid = stack.pop();
                //找左侧
                if (!stack.isEmpty()) {
                    int h = Math.min(height[stack.peek()], height[i]) - height[mid];
                    int w = i - stack.peek() - 1;
                    res += h * w;
                }
            }
            // 入栈
            stack.push(i);
        }
        return res;
    }

    // 真正的双指针法
    // left或者right就代表当前在处理哪个节点
    public int ___trap(int[] height) {

        int ans = 0;
        int left = 0, right = height.length - 1;
        // leftMax存储的是左指针左边（包括自己）的最大元素，rightMax存的是右指针右边（包括自己）的最大元素
        // maxLeft 对于 left 是可信的，maxRight 对于 right 是可信的，取当前可信的 max 与当前值 height[] 相减
        int leftMax = 0, rightMax = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                // 算左边的柱子
                ans += leftMax - height[left];
                ++left;
            } else {
                // 算右边的柱子
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}
