package main.sort;

/**
 * @program: java-code-study
 * @description: 链表
 * @author: zijie.zeng
 * @create: 2020-04-06 22:25
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {

    }
    public ListNode(int x) {
        val = x;
    }
    public static ListNode createListNode(Integer[] arrays) {
        ListNode root = new ListNode();
        ListNode head = root;
        for (Integer array : arrays) {
            head.next = new ListNode(array);
            head = head.next;
        }
        return root.next;
    }
    public static ListNode reverseListNode(ListNode root) {
        if (root == null) {
            return null;
        }
        ListNode head = null;
        ListNode ex = root;
        while (true) {
            ListNode mid = ex.next;
            ex.next = head;
            head = ex;
            ex = mid;
            if (ex==null) {
                break;
            }
        }
        return head;

    }
}
