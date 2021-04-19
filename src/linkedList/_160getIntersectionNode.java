package linkedList;

public class _160getIntersectionNode {
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

    // 利用两个指针，短链表走到头再走长链表，长链表走到头再走短链表即可
    // 考虑一种特殊情况，如果前面序列长度相等，那么相交处肯定会有pA==pB
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        // 如果有相交，两指针都走了a+b-c的路程，如果没有公共列表也是都走到了null
        return pA;
    }

}
