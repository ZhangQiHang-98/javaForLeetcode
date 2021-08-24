package stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class _155MinStack {
    // 相当于创建了一个辅助栈，辅助栈只用来存放每个元素对应的最小值
    class MinStack {
        Deque<Integer> xStack;
        Deque<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            xStack = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            xStack.push(val);
            minStack.push(Math.min(minStack.peek(), val));
        }

        public void pop() {
            xStack.pop();
            minStack.pop();
        }

        public int top() {
            return xStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
