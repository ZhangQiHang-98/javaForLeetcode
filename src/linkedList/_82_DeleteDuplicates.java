package linkedList;

public class _82_DeleteDuplicates {
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 设置一个虚拟头节点，因为本身头节点可能会被删除
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // slow 对应的当前最大的unique节点
        ListNode slow = dummy;
        ListNode fast = dummy.next;

        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            if (slow.next == fast) {
                slow = fast;
            } else {
                slow.next = fast.next;
            }
            fast = fast.next;
        }
        return dummy.next;
    }

}
