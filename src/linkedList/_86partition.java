package linkedList;

public class _86partition {
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

    public ListNode partition(ListNode head, int x) {
        // 第一种方法，直接一遍序列进行穿插,稍微有点复杂而且麻烦
/*        if (head == null || head.next == null) {
            return head;
        }
        // 哑节点
        ListNode dummy = new ListNode();
        dummy.next = head;

        //令slow走到第一个大于x处
        ListNode slow = dummy;
        // 判断，一定要先判断是否为空，再判断值
        while (slow.next != null && slow.next.val < x) {
            slow = slow.next;
        }
        ListNode fast = slow.next;
        ListNode next = new ListNode();
        while (fast != null) {
            next = fast.next;
            if (next != null && next.val < x ) {
                fast.next = next.next;
                next.next = slow.next;
                slow.next = next;
                // slow往后走一个
                slow = slow.next;
            }else {
                fast = fast.next;
            }
        }
        return dummy.next;*/

        // 第二种方法，分成两个链表，最终进行合并即可。
        if (head == null || head.next == null) {
            return head;
        }
        // 哑节点
        ListNode dummySmall = new ListNode();
        ListNode dummyBig = new ListNode();
        ListNode bigHead = dummyBig;
        ListNode smallHead = dummySmall;
        while (head != null) {
            if (head.val < x) {
                dummySmall.next = head;
                dummySmall = dummySmall.next;
            } else {
                dummyBig.next = head;
                dummyBig = dummyBig.next;
            }
            head = head.next;
        }
        // dummyBig此时预期达到新链表的最后一个数，因此next应该为Null
        dummyBig.next = null;
        dummySmall.next = bigHead.next;
        return smallHead.next;
    }
}
