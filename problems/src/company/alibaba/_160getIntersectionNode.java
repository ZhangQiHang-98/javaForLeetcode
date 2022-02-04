package company.alibaba;

/**
 * @Description 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * @Author Zhang Qihang
 * @Date 2022/2/3 16:37
 */
public class _160getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;
        ListNode tmp = headA;
        while (tmp != null) {
            len1++;
            tmp = tmp.next;
        }
        tmp = headB;
        while (tmp != null) {
            len2++;
            tmp = tmp.next;
        }
        // 链表A要长一些
        if (len1 > len2) {
            for (int i = len2; i < len1; i++) {
                headA = headA.next;
            }
        }
        if (len2 > len1) {
            for (int i = len1; i < len2; i++) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
