package company.alibaba;

/**
 * @Description 公共链表类
 * @Author Zhang Qihang
 * @Date 2022/1/29 16:10
 */
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
