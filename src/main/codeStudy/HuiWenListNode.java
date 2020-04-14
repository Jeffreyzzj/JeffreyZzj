package main.codeStudy;

import main.sort.ListNode;

import java.util.List;

/**
 * @program: java-code-study
 * @description: 面试题 02.06. 回文链表
 * @url https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
 * @author: zijie.zeng
 * @create: 2020-04-13 21:16
 */
public class HuiWenListNode {
    public static void main(String[] args) {
        pre();
    }
    private static void pre() {
        Integer[] arrays = {1,2};
        ListNode root = ListNode.createListNode(arrays);
        boolean res = isPalindrome(root);
        System.out.println();
    }
    private static boolean isPalindrome(ListNode root) {
        ListNode slow = root;
        ListNode fast = root;
        ListNode tagSlow = null;
        ListNode tagFast = null;
        while (true) {
            //慢指针走步
            ListNode mid = slow.next;
            //快指针走步
            fast = fast.next;

            slow.next = tagSlow;
            tagSlow = slow;
            slow = mid;

            if (fast==null) {
                tagFast = mid;
                tagSlow = tagSlow.next;
                break;
            }
            if (fast.next==null) {
                tagFast = mid;
                break;
            }
            fast = fast.next;
        }
        while (tagSlow!=null) {
            if (tagSlow.val != tagFast.val) {
                return false;
            }
            tagSlow = tagSlow.next;
            tagFast = tagFast.next;
        }
        return true;
    }
}
