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
}
