package linkedList;
//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
//
//返回同样按升序排列的结果链表。

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
            if (slow.next == fast) {    // 如果当前没有重复元素，即s与f紧连着，f没有跳跃
                slow = fast;
            } else {
                slow.next = fast.next;
            }
            fast = fast.next;
        }
        return dummy.next;
    }

}
