package linkedList;

import java.util.ArrayList;
import java.util.List;

public class _141hasCycle {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean hasCycle(ListNode head) {
/*        List<ListNode> res = new ArrayList<>();
        while (head!=null){
            if (res.contains(head)){
                return true;
            }
            res.add(head);
            head= head.next;
        }
        return false;*/
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
