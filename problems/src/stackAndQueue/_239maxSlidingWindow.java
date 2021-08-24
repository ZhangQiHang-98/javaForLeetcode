package stackAndQueue;

import java.util.ArrayDeque;

public class _239maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 滑动窗口类的问题需要用到单调队列（单调递减），此时队列出口处的元素即为窗口中的最大元素
        // 每个窗口的最大值，直接输出第一个元素即可。
        // ArrayDeque不是线程安全的，既可以用作栈，也可以用作队列。
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        // 输出的大小为n-k+1
        int[] res = new int[n - k + 1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            // pop操作，要判断当前队首元素是否要被移除
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                // 当窗口已经滑出队列最大值的下标时，
                deque.poll();
            }

            // 保证放进去的数字要比末尾的大，否则一直弹出队列最后的值
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            //offer：在队尾添加一个元素
            deque.offer(i);
            //当i增长到第一个符合k范围的时候（等于窗口长度），每次滑动的时候都将队列开头的值放入res即可
            if (i >= k - 1) {
                res[idx++] = nums[deque.peek()];
            }
        }
        return res;
    }
}
