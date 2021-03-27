package linkedList;

public class _21_MergeTwoLists {
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

/*    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 非递归方法
        ListNode head = new ListNode();
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode cur = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        if (p1 != null) {
            cur.next = p1;
        }
        if (p2 != null) {
            cur.next = p2;
        }
        return head.next;
    }*/


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 递归方法
        // 1.函数的目的：返回了已经排序好的链表
        // 2.终止条件：如果l1/l2走到头了，就返回另外一个（另外一个往后肯定是有序的）
        // 3.等价关系：l1与l2当前比较小的一个连接其余的。
        if(l1 == null){
            return l2;
        }
        if(l2 ==null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
