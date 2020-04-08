package main.niuke;

import main.sort.ListNode;

/**
 * @program: java-code-study
 * @description: 反转链表 II
 * @url https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @author: zijie.zeng
 * @create: 2020-04-07 23:06
 */
public class ReverseBetweenListNode {

    public static void main(String[] args) {
        preFun();
    }

    public static ListNode preFun() {
        ListNode head = new ListNode(1);
        ListNode mid = head;
        for (int i=2; i<6; i++) {
            mid.next = new ListNode(i);
            mid = mid.next;
        }
        //ListNode n =  reverseBetween(head, 2, 4);
        ListNode n = answer(head, 2, 4);
        return n;
    }


    public static ListNode answer(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 1; i < m; i++){
            pre = pre.next;
        }
        head = pre.next;
        for(int i = m; i < n; i++){
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }

}
