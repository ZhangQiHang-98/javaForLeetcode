package linkedList;

import javax.swing.*;

public class _234isPalindrome {
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

        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return false;
            }
            if (head.next == null) {
                return true;
            }
            // 利用快慢指针和反序
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode mid = slow.next;
            slow.next = null;
            // 将后面的列表进行反序
            mid = reverseList(mid);
            fast = head;
            while (mid != null) {
                if (mid.val != fast.val) {
                    System.out.println(mid.val);
                    System.out.println(fast.val);
                    return false;
                }
                mid = mid.next;
                fast = fast.next;
            }
            return true;
        }

        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }
    }
}
