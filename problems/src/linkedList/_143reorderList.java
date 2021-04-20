package linkedList;

import java.util.ArrayList;
import java.util.List;

public class _143reorderList {
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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 1.放到线性表中（list）
/*        List<ListNode> copyList = new ArrayList<ListNode>();
        ListNode cur = head;

        while (cur != null) {
            copyList.add(cur);
            cur = cur.next;
        }
        // 依此添加进去
        cur = head;
        ListNode temp = new ListNode();
        int critical = copyList.size() % 2 == 1 ? copyList.size() / 2 : copyList.size() / 2 - 1;
        for (int i = copyList.size() - 1; i > critical; i--) {
            temp = cur.next;
            cur.next = copyList.get(i);
            copyList.get(i).next = temp;
            cur = temp;
        }
        cur.next = null;*/

        // 2. 不用额外空间的话，相当于是链表的左半段和反转的右半端依此合并的结果
        // 首先找到链表的中点，快慢指针,从head开始，会走到中点向上取整处，而从dummy开始，会走到中点向下取整处，根据题意，选择从head开始
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        ListNode temp = mid.next;
        mid.next = null;
        // 反转后半段链表,反转之前一定要先切断
        mid = reverseLinkedList(temp);
        ListNode cur = head;
        ListNode next;
        ListNode next2;
        // 开始依此合并
        while (mid != null) {
            next = cur.next;
            next2 = mid.next;
            cur.next = mid;
            cur = next;
            mid.next = cur;
            mid = next2;
        }
    }

    private ListNode reverseLinkedList(ListNode head) {
        // 如果用new ListNode， 就多了一个元素，如果用=null，则不会
        ListNode pre = new ListNode();
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }
}

/*
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/reorder-list/solution/zhong-pai-lian-biao-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
* */
