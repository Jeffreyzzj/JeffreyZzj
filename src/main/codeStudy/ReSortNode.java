package main.codeStudy;

import main.sort.ListNode;

/**
 * @program: java-code-study
 * @description: 143. 重排链表
 * @url https://leetcode-cn.com/problems/reorder-list/
 * @author: zijie.zeng
 * @create: 2020-04-13 20:20
 */
public class ReSortNode {
    public static void main(String[] args) {
        pre();
    }
    public static void pre() {
        Integer[] arrays = {1,2};
        ListNode root = ListNode.createListNode(arrays);
        ListNode node = reSort(root);
        System.out.println();
    }
    public static ListNode reSort(ListNode root) {
        if (root==null || root.next==null || root.next.next ==null) {
            return root;
        }
        ListNode slow = root;
        ListNode fast = root;
        while (fast!=null && fast.next!=null) {
            slow= slow.next;
            fast = fast.next;
            if (fast==null) {
                break;
            } else {
                fast = fast.next;
            }
        }
        ListNode mid = slow.next;
        slow.next = null;

        ListNode behind = reverseNode(mid);
        ListNode head = root;
        while (true) {
            ListNode beMid = behind.next;
            behind.next = head.next;
            head.next = behind;
            head = behind.next;
            behind = beMid;
            if (behind==null || head==null) {
                break;
            }
        }
        //System.out.println("===");
        return root;
    }
    private static ListNode reverseNode(ListNode root) {
        if (root==null) {
            return null;
        }
        ListNode head = null;
        while (true) {
            ListNode mid = root.next;
            root.next = head;
            head = root;
            root = mid;
            if (root==null) break;
        }
        return head;
    }
}
