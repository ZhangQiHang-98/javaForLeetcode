package linkedList;

public class _142detectCycle {

    public ListNode detectCycle(ListNode head) {
        // 慢指针一次走一步，快指针一次走两步
        // 如果有环，快指针一定是先进入环的，然后仿照跑步套圈，跑的快的一定能追上跑的慢的
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            // 无环的情况，直接返回null即可
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
