package company.alibaba;

/**
 * @Description 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @Author Zhang Qihang
 * @Date 2022/2/2 17:57
 */
public class _19removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 搞一个快慢指针，快指针先往前走N步，满指针再走
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
}
