package company.alibaba;

import java.rmi.UnexpectedException;

/**
 * @Description 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表
 * @Author Zhang Qihang
 * @Date 2022/2/2 16:54
 */
public class _25reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 先创建一个虚拟节点
        ListNode dummy = new ListNode();
        dummy.next = head;

        // 创建两个指针 pre和end,pre代表待反转链表的前驱，end表示待反转链表的末尾，每个循环开始的时候，pre和end指针应该在一起
        ListNode pre = dummy;
        ListNode end = dummy;

        // 当end走到最尾端，说明所有的节点已经反转好了
        while (end != null) {
            // 每次循环的时候，先让end走到当前循环的末尾处，如果少于K，同样走到最末尾
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 如果end走到Null了，说明这一步不足K，退出即可，如果最后不足K个也要反转，就不加这个条件即可
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode after = end.next;

            // 然后断开end
            end.next = null;
            pre.next = reverseHelp(start);
            //然后将反转后的链表接上
            start.next = after;

            //进行下一次循环
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    // 逆序链表
    public ListNode reverseHelp(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


    // 还有一种方法就是递归，递归这里，每次先处理好自己的，然后处理后面的
    // 递归函数的返回值，是从head到head+k这段链表反转后的头节点
    public ListNode _reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // 找到要反转的尾巴
        ListNode tail = head;
        for (int i = 0; i < k; i++) {

            if (tail == null) {
                // 这段不用反转了，直接返回就行
                return head;
            }
            tail = tail.next;
        }

        // 反转
        ListNode newHead = reverseHelp2(head, tail);
        // 下一轮就应该是从tail开始反转,此时的head已经变成了末尾
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    // 左闭右开区间
    public ListNode reverseHelp2(ListNode head, ListNode tail) {
        ListNode pre = null;
        while (head != tail) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
