package company.alibaba;


import linkedList._206_ReverseList;

/**
 * @Description 给定头节点head，反转链表
 * @Author Zhang Qihang
 * @Date 2022/1/30 16:34
 */
public class _206reverseList {
    // 两种方法，迭代和递归
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        // 多开一个，否则会有环!!
        ListNode pre = null;
        //cur不等于null为循环结束条件，这样才能让cur取到最后一个值
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // 返回值和参数：可以直接复用
    public ListNode _reverseList(ListNode head) {
        // 递归的终止条件
        if (head == null || head.next == null) {
            return head;
        }

        // cur里面保存的是一直是头节点(反转后的)!!
        ListNode cur = _reverseList(head.next);
        // 单层逻辑
        head.next.next = head;
        head.next = null;
        return cur;
    }

}

