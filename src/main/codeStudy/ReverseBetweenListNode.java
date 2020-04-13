package main.codeStudy;

import main.sort.SingleNode;

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

    public static SingleNode preFun() {
        SingleNode head = new SingleNode(1);
        SingleNode mid = head;
        for (int i=2; i<6; i++) {
            mid.next = new SingleNode(i);
            mid = mid.next;
        }
        //ListNode n =  reverseBetween(head, 2, 4);
        SingleNode n = answer(head, 2, 4);
        return n;
    }


    public static SingleNode answer(SingleNode head, int m, int n) {
        SingleNode dummy = new SingleNode(0);
        dummy.next = head;
        SingleNode pre = dummy;
        for(int i = 1; i < m; i++){
            pre = pre.next;
        }
        head = pre.next;
        for(int i = m; i < n; i++){
            SingleNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }

}
