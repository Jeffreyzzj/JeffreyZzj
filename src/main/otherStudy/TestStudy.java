package main.otherStudy;

import main.sort.ListNode;
import main.sort.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @program: java-code-study
 * @description: myself study
 * @author: zijie.zeng
 * @create: 2019-11-28 23:28
 */
public class TestStudy {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        testListNode();
    }
    public static void testListNode() {
        Integer[] arrays = {1,2,3,4,5};
        ListNode root = ListNode.createListNode(arrays);

        //部分转换
        //SingleNode partNode = SingleNode.reverseListNode(root, 1, 5);
        //全部转换
        //SingleNode allNode = SingleNode.reverseListNode(root);

        //向后移动位
        ListNode res = ListNode.moveListNode(root, 5);

        System.out.println();
    }

    public static ListNode answer(ListNode head, int k) {
        if(head==null||k==0){
            return head;
        }
        ListNode cursor=head;
        ListNode tail=null;//尾指针
        int length=1;
        while(cursor.next!=null)//循环 得到总长度
        {
            cursor=cursor.next;
            length++;
        }
        int a = k%length;
        int loop=length-a;//得到循环的次数
        tail=cursor;//指向尾结点
        cursor.next=head;//改成循环链表
        cursor=head;//指向头结点
        for(int i=0;i<loop;i++){//开始循环
            cursor=cursor.next;
            tail=tail.next;
        }
        tail.next=null;//改成单链表
        return cursor;//返回当前头
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head==null || k==0) {
            return head;
        }
        //获得链表长度
        int count = 1;
        ListNode root = head;
        while (root.next!=null) {
            count++;
            root = root.next;
        }
        //链表变环
        root.next = head;
        root = root.next;

        k = k%count;

        for (int i=1; i<count-k; i++) {
            root = root.next;
        }
        head = root.next;
        root.next = null;
        return head;
    }

    public static void studyOther() {
        //int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        //Integer[] array = {0, 1, 2, 3, 3, 4, 5, null, null, 10, null, null, 7, 8};

        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            int start = i;
            int end = len - i - 1;
            for (int j = 0; j < end - start; j++) {
                int temp = matrix[start][start + j];
                matrix[start][start + j] = matrix[end - j][start];
                matrix[end - j][start] = matrix[end][end - j];
                matrix[end][end - j] = matrix[start + j][end];
                matrix[start + j][end] = temp;
            }
        }

        System.out.println("---");
        //leetCodeDeleteOneNode();
    }

    public static void leetCodeDeleteOneNode() {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        head.next = head2;
        deleteOneNode(head, 2);
        System.out.println("====");
    }

    public static ListNode deleteOneNode(ListNode head, int n) {
        if (head==null) {
            return null;
        }
        List<ListNode> resList = new ArrayList<>();
        while (head != null) {
            resList.add(head);
            head = head.next;
        }
        int deleteIndex = resList.size() - n;
        if (deleteIndex>resList.size()) {
            return resList.get(0);
        }

        if (deleteIndex-1<0) {
            //长度等于0，那么相当于把头节点删掉
            resList.add(0, resList.get(1));
        } else {
            resList.get(deleteIndex-1).next = resList.get(deleteIndex).next;
        }

        return resList.get(0);
    }

    /*public static int conversionArraySearchTarget(int[] nums, int target) {
        if (nums.length==0) {
            return -1;
        }
        int left = 0;
        int right = nums.length-1;

        int mid = 0;
        while (true) {
            mid = (right + left)/2;
            if (nums[mid] == target) {
                break;
            } else if (left>=right) {
                return -1;
            }

            if (nums[left]<nums[mid]) {
                //左半段有序
                if (nums[left]<=target && target<=nums[mid]) {
                    right = --mid;
                } else {
                    left = ++mid;
                }
                continue;
            } else if (nums[mid+1]<=nums[right]) {
                //右半段有序
                if (nums[mid+1]<=target && target<=nums[right]) {
                    left = ++mid;
                } else {
                    right = --mid;
                }
                continue;
            }
        }
        return mid;
    }*/


    public static List<Integer> studyTreeNodeFun(Integer[] array) {
        //创建二叉树
        TreeNode treeNode = TreeNode.createTreeNode(array, 0);

        //前序遍历
        List<Integer> preList = new ArrayList<>();
        TreeNode.orderByPreTraversal(treeNode, preList);

        //中序遍历
        List<Integer> midList = new ArrayList<>();
        TreeNode.orderByMidTraversal(treeNode, midList);

        //后序遍历
        List<Integer> behindList = new ArrayList<>();
        //创建二叉树
        TreeNode.orderByBehindTraversal(treeNode, behindList);

        return behindList;
    }

    public void testA() {
        String first = "first";
        String second = new String("first");
        "first".concat("second");
        System.out.println(first.equals(second));
        System.out.println(first == second);
        System.out.println(first.equals("firstsecond"));
        System.out.println(second == "first");

        System.out.println(Stream.of("green", "yellow", "blue")
                .max((s1, s2) -> s1.compareTo(s2))
                .filter(s -> s.endsWith("n"))
                .orElse("yellow"));
    }


    /*public void createTreeNode(int[] arrayNodes, TreeNode root) {
        if (root == null) {
            return;
        }
        //左节点
        int childLeftIndex = root.index<<2+1;
        if (childLeftIndex <= arrayNodes.length) {
            TreeNode left = new TreeNode(arrayNodes[childLeftIndex]);
            left.index = childLeftIndex;
            root.left = left;

            createTreeNode(arrayNodes, left);
        }
        //左节点
        int childRightIndex = childLeftIndex+1;
        if (childRightIndex <= arrayNodes.length) {
            TreeNode right = new TreeNode(arrayNodes[childRightIndex]);
            right.index = childRightIndex;
            root.right = right;
            createTreeNode(arrayNodes, right);
        }

    }*/

}
