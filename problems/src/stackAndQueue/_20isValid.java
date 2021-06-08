package stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class _20isValid {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                deque.addLast(')');
            } else if (s.charAt(i) == '{') {
                deque.addLast('}');
            } else if (s.charAt(i) == '[') {
                deque.addLast(']');
            } else if (deque.isEmpty() || s.charAt(i) != deque.pollLast()) {
                return false;
            }
        }
        return deque.isEmpty();
    }
}
