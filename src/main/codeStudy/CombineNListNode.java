package main.codeStudy;

import main.sort.SingleNode;

/**
 * @program: java-code-study
 * @description: 合并多个排序链表
 * @author: zijie.zeng
 * @create: 2020-04-07 10:51
 */
public class CombineNListNode {
    public static void main(String[] args) {
        pre();
    }

    public static void pre() {
        SingleNode[] lists = new SingleNode[3];
        SingleNode one = new SingleNode(0);
        SingleNode two = new SingleNode(1);
        SingleNode three = new SingleNode(2);
        lists[0] = one;
        lists[1] = two;
        lists[2] = three;
        for (int i = 0; i < 3; i++) {
            int index = i % 3;
            lists[index].next = new SingleNode(i);
            lists[index] = lists[index].next;
        }
        SingleNode[] paramList = new SingleNode[3];
        paramList[0] = one;
        paramList[1] = two;
        paramList[2] = three;
        SingleNode res = mergeKLists(paramList);
        System.out.println("===");
    }

    public static SingleNode mergeKLists(SingleNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                break;
            } else if (i == lists.length - 1) {
                return null;
            }
        }
        if (lists.length == 1) {
            return lists[0];
        }
        SingleNode head = new SingleNode();
        SingleNode root = head;
        int index = 0;
        while (true) {
            for (int i = 0; i < lists.length; i++) {

                if (lists[i] == null) {
                    continue;
                }
                if (lists[index] == null || lists[index].val > lists[i].val) {
                    index = i;
                }
            }
            root.val = lists[index].val;
            lists[index] = lists[index].next;
            if (!hasNext(lists)) {
                break;
            }
            root.next = new SingleNode();
            root = root.next;

        }
        return head;
    }

    public static boolean hasNext(SingleNode[] lists) {
        for (SingleNode listNode : lists) {
            if (listNode != null) {
                return true;
            }
        }
        return false;
    }
}
