package company.alibaba;

/**
 * @Description 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表
 * @Author Zhang Qihang
 * @Date 2022/2/5 16:16
 */
public class _92reverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 定4个指针，分别指向前后与链表的开头结尾
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode oldEnd = dummy;
        // 这里用for更好
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        for (int i = 0; i < right; i++) {
            oldEnd = oldEnd.next;
        }

        ListNode last = oldEnd.next;
        ListNode oldStart = pre.next;
        // 断开
        pre.next = null;
        oldEnd.next = null;

        // 反转
        reverse(oldStart);
        pre.next = oldEnd;
        oldStart.next = last;
        return dummy.next;
    }

    public void reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
    }


    public ListNode _reverseBetween(ListNode head, int left, int right) {
        // 头插法
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // cur永远指向待反转区域的第一个节点
        // next永远指向cur的后一个节点
        // 当前要处理那个元素
        ListNode cur = pre.next;
        ListNode next;
        for (int i = left; i < right; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }
}
