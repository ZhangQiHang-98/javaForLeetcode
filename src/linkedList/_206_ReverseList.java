package linkedList;


public class _206_ReverseList {
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


    public ListNode reverseList(ListNode head) {
        // 递归终止条件,空链表或者是已经到了最小子问题
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        // 置空，防止有环产生
        head.next = null;
        // p就是反转后的头节点
        return p;
    }


/*    public ListNode reverseList(ListNode head) {
        // 迭代反转（循环反转）,永远让cur从head开始
        ListNode cur = head;
        // 反转后开头变成了null
        ListNode pre = null;
        //cur不等于null为循环结束条件，这样才能让cur取到最后一个值
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }*/
}
