package stackAndQueue;

import java.util.*;

public class _239maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 滑动窗口类的问题需要用到单调队列（单调递减），此时队列出口处的元素即为窗口中的最大元素
        // 每个窗口的最大值，直接输出第一个元素即可。
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            // 判断队头是否还在滑动窗口的范围内
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.pollFirst();
            }
            // 当前元素要小于末尾元素，否则末尾元素弹出
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                res[idx++] = nums[deque.peekFirst()];
            }
        }
        return res;
        //
    }

    public int[] _maxSlidingWindow(int[] nums, int k) {
        // 利用优先队列解题
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (i > k) {
                pq.remove(nums[i - k]);
            }
            pq.add(nums[i]);
            if (i >= k - 1) {
                res[i - k + 1] = nums[pq.peek()];
            }
        }
        return res;
    }
}
