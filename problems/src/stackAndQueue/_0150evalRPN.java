package stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class _0150evalRPN {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList();
        for (String token : tokens) {
            char c = token.charAt(0);
            if (!isOpe(token)) {
                stack.addFirst(stoi(token));
            } else if (c == '+') {
                stack.push(stack.pop() + stack.pop());
            } else if (c == '-') {
                stack.push(- stack.pop() + stack.pop());
            } else if (c == '*') {
                stack.push( stack.pop() * stack.pop());
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push( num2/num1);
            }
        }
        return stack.pop();
    }


    private boolean isOpe(String s) {
        return s.length() == 1 && s.charAt(0) <'0' || s.charAt(0) >'9';
    }

    private int stoi(String s) {
        return Integer.valueOf(s);
    }
}
