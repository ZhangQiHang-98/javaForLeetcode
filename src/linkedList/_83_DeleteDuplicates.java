package linkedList;

public class _83_DeleteDuplicates {
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
        ListNode cur = head;
        ListNode p = head.next;
        while (p != null) {
            if(p.val != cur.val){
                cur.next = p;
                cur = p;
            }
            p = p.next;
        }
        // p指针一定走到了null，cur是当前最大的unique的元素，最后让cur指向null即可
        cur.next = null;
        return head;
    }
}
