package linkedList;

import java.util.List;

public class _147insertSortList {
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

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

/*        //lastSorted指向当前排好序的最后一个元素 cur指向最开始的元素，让元素从cur->lastSorted之间循环遍历，
          // 可以优化的一点是，直接让lastSorted.next跟lastSorted比，如果大的话，就不用插入了
        ListNode cur = dummy;
        ListNode lastSorted = head;
        ListNode lastSortedTemp;
        // 记一个flag指针，看lastSorted.next有没有变，没有变则往后推一位
        int flag = 0;

        while (lastSorted != null && lastSorted.next != null) {
            cur = dummy;
            flag = 0;
            while (cur != lastSorted) {
                // 如果当前的值比未排序的值大的话那就插入，否则就一直往后移
                if (cur.next.val >= lastSorted.next.val) {
                    lastSortedTemp = lastSorted.next;
                    lastSorted.next = lastSortedTemp.next;
                    lastSortedTemp.next = cur.next;
                    cur.next = lastSortedTemp;
                    flag = 1;
                    // 插入一次之后，跳出当前循环
                    break;
                } else {
                    cur = cur.next;
                }
                // 如果比到最后都小于的话，说明排序对了位置，直接往后移动就可以
            }
            // 继续往后比较,此时,lastSorted.next已经指向了下一个新的未排序的值了，因此不需要再.next
            if (flag == 0) {
                lastSorted = lastSorted.next;
            }
        }
        return dummy.next;*/

        // lastSorted指向排好序的最后一个元素，curr指向当前未排序的第一个元素
        ListNode lastSorted = head;
        ListNode curr = head.next;
        ListNode pre = dummy;
        // curr为空也就表示没有未排序的元素了
        while (curr != null) {
            //要改成>=，如果不是>=的话，11这样的，curr就没法往前换了，就卡住了。
            if (curr.val >= lastSorted.val) {
                // 直接让lastSorted向后移一个。
                lastSorted = lastSorted.next;
            } else {
                pre = dummy;
                while (pre != lastSorted) {
                    // pre在已排序中遍历
                    if (pre.next.val >= curr.val) {
                        lastSorted.next = curr.next;
                        curr.next = pre.next;
                        pre.next = curr;
                        break;
                    } else {
                        pre = pre.next;
                    }
                }
            }
            // 始终保证lastSorted指向排好序的最后一个元素，curr为lastSorted后面一个
            curr = lastSorted.next;
        }
        return dummy.next;
    }
}
