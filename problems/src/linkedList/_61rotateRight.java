package linkedList;

public class _61rotateRight {
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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

        // 链表总长度
        ListNode p = head;
        int size = 1;
        while (p.next != null) {
            size++;
            p = p.next;
        }
        // 现在p已经到了tail处

        // 计算把倒数多少个数往前挪
        k = k % size;
        if(k == 0){
            return head;
        }
        int interval = size - k;

        ListNode cur = dummy;
        while (interval != 0) {
            cur = cur.next;
            interval--;
        }
        //cur在pre处
        dummy.next = cur.next;
        p.next = head;
        cur.next = null;
        return dummy.next;
    }
}
