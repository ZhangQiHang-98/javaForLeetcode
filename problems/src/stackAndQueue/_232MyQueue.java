package stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class _232MyQueue {

    // java中的 Stack 有设计上的缺陷，官方推荐使用 Deque(双端队列) 代替 Stack
    // Deque 中的 addFirst、removeFirst、peekFirst 等方法等效于 Stack(堆栈) 中的 push、pop、peek
    Deque<Integer> stIn;
    Deque<Integer> stOut;

    /**
     * Initialize your data structure here.
     */
/*    public MyQueue() {
        stIn = new ArrayDeque<>();
        stOut = new ArrayDeque<>();
    }*/

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stIn.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        // 只要 stOut 为空，那么就应该将 stIn 中所有的元素倒腾到 stOut 中
        if (stOut.isEmpty()) {
            while (!stIn.isEmpty()) {
                stOut.push(stIn.pop());
            }
        }
        // 再返回 stOut 中的元素
        return stOut.pollLast();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        // 直接使用已有的pop函数
        int res = this.pop();
        // 因为pop函数弹出了元素res，所以再添加回去
        stOut.addLast(res);
        return res;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        // 当 stIn 栈为空时，说明没有元素可以倒腾到 stOut 栈了
        // 并且 stOut 栈也为空时，说明没有以前从 stIn 中倒腾到的元素了
        return stIn.isEmpty() && stOut.isEmpty();
    }
}
