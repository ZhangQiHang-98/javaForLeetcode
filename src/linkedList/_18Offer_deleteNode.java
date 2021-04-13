package linkedList;

// 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
public class _18Offer_deleteNode {
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

    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        // pre是当前index最大的不为val的值，pre永远存储的是latest的correct
        ListNode pre = dummy;
        ListNode cur = head;
        if (head == null) {
            return head;
        }
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre.next = cur;
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
