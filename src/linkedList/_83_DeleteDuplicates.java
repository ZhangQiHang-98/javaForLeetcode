package linkedList;
//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
//
//返回同样按升序排列的结果链表。
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
