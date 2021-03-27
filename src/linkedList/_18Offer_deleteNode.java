package linkedList;

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
        // pre是当前index最大的不为val的值
        ListNode pre = dummy;
        ListNode cur = head;
        if (head == null) {
            return head;
        }
        while (cur!=null){
            if(cur.val == val){
                pre.next = cur.next;
            }else {
                pre.next = cur;
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
