package main.codeStudy;

import main.sort.SingleNode;

/**
 * @program: java-code-study
 * @description: 判断链表是否有环
 * @author: zijie.zeng
 * @create: 2020-04-10 21:44
 */
public class NodeHasCircle {
    public static void main(String[] args) {
        Integer[] arrays = {1,2,3,4,5,6,7,8,9};
        SingleNode root = SingleNode.createListNode(arrays);
        //创建环
        SingleNode head = root;
        SingleNode mid = root;
        for (int i=0; i<arrays.length; i++) {
            if (i==5) {
                mid = head;
            }
            head = head.next;
            if (i==arrays.length-2) {
                head.next = mid;
            }
        }

        SingleNode slow = root.next;
        SingleNode fast = slow.next;

        boolean hasCircle = false;
        while (fast!=null || slow!=null) {
            if (fast == slow) {
                hasCircle = true;
                break;
            }
            slow = slow.next;
            if (fast.next==null) {
                break;
            } else {
                fast = fast.next;
            }
            fast = fast.next;
        }

        //如果有环
        //求环长
        int length = 1;
        if (hasCircle) {

            fast = fast.next;
            while (fast!=slow) {
                length++;
                fast = fast.next;
            }
        }
        System.out.println("====");
    }
}
