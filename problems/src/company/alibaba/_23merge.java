package company.alibaba;

import java.util.List;

/**
 * @Description 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * @Author Zhang Qihang
 * @Date 2022/2/1 23:02
 */
public class _23merge {
    public void _88merge(int[] nums1, int m, int[] nums2, int n) {
        // 从前往后会涉及到移动元素，比较复杂，还是从后往前好,如果是链表的话，从前往后比较方便~
        int p1 = m - 1;
        int p2 = n - 1;
        int cur = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            //判断是填入num1还是num2
            if (nums1[p1] > nums2[p2]) {
                nums1[cur--] = nums1[p1--];
            } else {
                nums1[cur--] = nums2[p2--];
            }
        }
        // nums1本来就在序列中了，所以如果剩下的话，一定是已经排序好的
        while (p2 >= 0) {
            nums1[p1--] = nums2[p2--];
        }
    }

    public ListNode _2merge(ListNode a, ListNode b) {
        // 起一个虚拟头节点
        ListNode dummy = new ListNode();
        // 三个指针
        ListNode cur = dummy, pa = a, pb = b;
        while (pa != null && pb != null) {
            if (pa.val > pb.val) {
                cur.next = pa;
                pa = pa.next;
            } else {
                cur.next = pb;
                pb = pb.next;
            }
            cur = cur.next;
        }
        // 这里肯定有一个为空了
        if (pa == null) {
            cur.next = pb;
        } else {
            cur.next = pa;
        }
        return dummy.next;
    }

    // 第一个方法：类似于上面的 合并K次呗
    // 第二个方法：归并合并
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        // 写一个合并方法，合并从[i,j]区间内的链表
        return mergeHelper(lists, 0, lists.length - 1);
    }

    public ListNode mergeHelper(ListNode[] lists, int l, int r) {
        // 递归的中止条件
        if (l == r) {
            return lists[l];
        }
        int mid = l + (r - l) / 2;
        return _2merge(mergeHelper(lists, l, mid), mergeHelper(lists, mid + 1, r));
    }
}
