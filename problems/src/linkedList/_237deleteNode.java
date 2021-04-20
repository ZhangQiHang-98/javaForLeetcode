package linkedList;

public class _237deleteNode {
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

    public void deleteNode(ListNode node) {
        // 让node 变成下一个，然后删除下一个
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
