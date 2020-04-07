package main.otherStudy;

import main.sort.ListNode;
import main.sort.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

/**
 * @program: java-code-study
 * @description: myself study
 * @author: zijie.zeng
 * @create: 2019-11-28 23:28
 */
public class TestStudy {
    public static void main(String[] args) {
        //int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        //Integer[] array = {0, 1, 2, 3, 3, 4, 5, null, null, 10, null, null, 7, 8};

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        leetCodeDeleteOneNode();

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
