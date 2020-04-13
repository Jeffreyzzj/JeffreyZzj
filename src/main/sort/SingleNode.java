package main.sort;

/**
 * @program: java-code-study
 * @description: 链表
 * @author: zijie.zeng
 * @create: 2020-04-06 22:25
 */
public class SingleNode {
    public int val;
    public SingleNode next;
    public SingleNode() {

    }
    public SingleNode(int x) {
        val = x;
    }

    /**
     * @description 创建链表
     * @param arrays
     * @return
     */
    public static SingleNode createListNode(Integer[] arrays) {
        SingleNode root = new SingleNode();
        SingleNode head = root;
        for (Integer array : arrays) {
            head.next = new SingleNode(array);
            head = head.next;
        }
        return root.next;
    }

    /**
     * @反转链表，从尾节点到头节点
     * @param root
     * @return
     */
    public static SingleNode reverseListNode(SingleNode root) {
        if (root == null) {
            return null;
        }
        SingleNode head = null;
        while (true) {
            SingleNode mid = root.next;
            root.next = head;
            head = root;
            root = mid;
            if (root==null) {
                break;
            }
        }
        return head;
    }

    /**
     * @description 特定序列段反转
     * @param root
     * @return
     */
    public static SingleNode reverseListNode(SingleNode root, int start, int end) {
        //用于操作
        SingleNode head = new SingleNode();
        head.next = root;
        //用于返回
        SingleNode res = head;
        for (int i=1; i<start; i++) {
            head = head.next;
        }
        SingleNode tailNode = head.next;
        for (int i=start; i<end; i++) {
            SingleNode exNode = tailNode.next;
            if (exNode==null) {
                break;
            }
            tailNode.next = exNode.next;
            exNode.next = head.next;
            head.next = exNode;
        }
        return res.next;
    }

    public static SingleNode moveListNode(SingleNode root, int num) {
        if (root==null || num==0) {
            return root;
        }

        //查询链表长度
        int count = 1;
        SingleNode head = root;
        while (head.next!=null) {
            head = head.next;
            count++;
        }

        if (num%count==0) {
            return root;
        }

        //首位相接
        head.next = root;
        head = root;

        //确定链表断开位置
        int index = count - num%count;
        for (int i=1; i<index; i++) {
            head = head.next;
        }
        root = head.next;
        head.next = null;
        return root;
    }
}
