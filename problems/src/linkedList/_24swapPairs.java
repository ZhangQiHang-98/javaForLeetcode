package linkedList;


public class _24swapPairs {
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

    public ListNode swapPairs(ListNode head) {
/*        if (head == null || head.next == null) {
            return head;
        }
        // 哑节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        //
        ListNode current = dummy;
        // current到倒数第3个终止
        while (current.next != null && current.next.next !=null) {
            ListNode first = current.next;
            ListNode second = current.next.next;

            first.next = second.next;
            second.next = first;
            current.next = second;
            current = current.next.next;
        }
        return dummy.next;*/
        // 递归解法
        // 1.函数的目的，返回值：返回已经两两交换的链表
        // 2.终止条件：链表中节点<2
        // 3.调用单元：将 node2 指向 node1，node1 指向下一层的递归函数，最后返回节点 node2
        if (head == null || head.next == null) {    // 终止条件
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        // 下一层的递归函数入口
        ListNode next = second.next;

        second.next = first;
        first.next = swapPairs(next);
        return second;
    }
}
