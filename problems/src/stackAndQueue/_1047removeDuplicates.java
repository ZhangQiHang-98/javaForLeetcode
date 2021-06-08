package stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class _1047removeDuplicates {
    public String removeDuplicates(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (deque.isEmpty() || deque.peekLast() != s.charAt(i)) {
                deque.addLast(s.charAt(i));
            } else {
                deque.pollLast();
            }
        }
        while (!deque.isEmpty()) {
            res.append(deque.pollLast());
        }
        return res.reverse().toString();
    }
}
