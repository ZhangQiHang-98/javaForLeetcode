package linkedList;

public class _19removeNthFromEnd {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        ListNode pre = dummy;
        // 两趟实现
/*        int size = 0;
        while (p != null) {
            size++;
            p = p.next;
        }
        int del_index = size - n;
        p = head;
        while (p != null) {
            if (del_index == 0) {
                pre.next = p.next;
                break;
            }
            del_index--;
            p = p.next;
            pre = pre.next;
        }
        return dummy.next;*/
        // 一趟实现，快慢节点法
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        while (cur.next != null) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}
