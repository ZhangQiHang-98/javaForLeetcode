package company.alibaba;

import java.util.Stack;

/**
 * @Description 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * @Author Zhang Qihang
 * @Date 2022/2/3 16:07
 */
class MinStack {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int val) {
        if (!s2.isEmpty() && val > s2.peek()) {
            s2.push(s2.peek());
        } else {
            s2.push(val);
        }
        s1.push(val);
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }

    // 优化做法：栈存储差值
}