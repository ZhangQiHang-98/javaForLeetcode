package linkedList;

public class _92reverseBetween {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 穿针引线的方法，直接全部反转，然后再连接
/*        if (head == null || head.next == null || left == right) {
            return head;
        }
        // 四个指针abcd
        ListNode pre = new ListNode();
        ListNode last = new ListNode();
        ListNode leftNode = new ListNode();
        ListNode rightNode = new ListNode();

        ListNode dummy = new ListNode();
        dummy.next = head;

        pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        leftNode = pre.next;

        rightNode = dummy;
        for (int i = 0; i < right; i++) {
            rightNode = rightNode.next;
        }
        last = rightNode.next;

        // 切断中间的链表，否则可能会有重叠的部分
        // 对选中的链表进行反序操作
        pre.next = null;
        rightNode.next = null;
        reverseLinkedList(leftNode);
        // 开始连线
        pre.next = rightNode;
        leftNode.next = last;
        return dummy.next;*/

        // 头插法，在需要反转的区间里重复将元素插入在头部
        ListNode dummy = new ListNode();
        ListNode pre = new ListNode();
        ListNode next = new ListNode();
        dummy.next = head;

        pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            //next要移到pre之后
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }

    private void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

}
