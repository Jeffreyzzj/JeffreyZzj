package main.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: java-code-study
 * @description: 二叉树对象
 * @author: zijie.zeng
 * @create: 2020-01-16 00:05
 */
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public int index;

    public TreeNode() {
    }

    public TreeNode(Integer value) {
        this.val = value;
    }

    /**
     * @param arrayNodes
     * @param root
     * @description 类似深度遍历的方式构建二叉树，赋值了数组的下标值（广度遍历）
     * @// TODO: 2020/4/4 逻辑有些问题，不建议使用
     */
    public static void createTreeNode(Integer[] arrayNodes, TreeNode root) {
        if (root == null) {
            return;
        }
        //左节点
        int childLeftIndex = (root.index << 1) + 1;
        if (childLeftIndex < arrayNodes.length) {
            TreeNode left = new TreeNode(arrayNodes[childLeftIndex]);
            left.index = childLeftIndex;
            root.left = left;

            createTreeNode(arrayNodes, left);
        }
        //左节点
        int childRightIndex = childLeftIndex + 1;
        if (childRightIndex < arrayNodes.length) {
            TreeNode right = new TreeNode(arrayNodes[childRightIndex]);
            right.index = childRightIndex;
            root.right = right;
            createTreeNode(arrayNodes, right);
        }
    }

    /**
     * @param arrayNodes
     * @param index
     * @return
     * @description 简单构建二叉树
     */
    public static TreeNode createTreeNode(Integer[] arrayNodes, int index) {
        TreeNode treeNode = null;
        if (index < arrayNodes.length && arrayNodes[index] != null) {
            treeNode = new TreeNode(arrayNodes[index]);
            int left = (index << 1) + 1;
            treeNode.left = createTreeNode(arrayNodes, left);
            treeNode.right = createTreeNode(arrayNodes, left + 1);
        }
        return treeNode;
    }
    public static TreeNode createTreeNode(Integer[] arrayNodes) {
        return createTreeNode(arrayNodes, 0);
    }

    /**
     * @param root
     * @return
     * @description 前序遍历
     * @extra 内部创建list，只需要根据节点即可返回前序遍历
     * @// TODO: 2020/4/4 逻辑可以优化
     */
    public static List<Integer> orderByPreTraversal(TreeNode root) {
        List<Integer> listRes = new ArrayList<>();

        if (root == null) {
            return listRes;
        }

        listRes.add(root.val);
        //根据有无节点进行遍历
        if (root.left != null) {
            listRes.addAll(orderByPreTraversal(root.left));
        }
        if (root.right != null) {
            listRes.addAll(orderByPreTraversal(root.right));
        }

        return listRes;
    }

    /**
     * @param root
     * @param resList
     * @description 前序遍历
     * @extra 前序遍历，将值存到传入的list
     */
    public static void orderByPreTraversal(TreeNode root, List<Integer> resList) {
        if (root == null) {
            return;
        } else if (resList == null) {
            resList = new ArrayList<>();
        }

        resList.add(root.val);
        orderByPreTraversal(root.left, resList);
        orderByPreTraversal(root.right, resList);
    }

    /**
     * @param root
     * @param resList
     * @description 中序遍历
     */
    public static void orderByMidTraversal(TreeNode root, List<Integer> resList) {
        if (root == null) {
            return;
        } else if (resList == null) {
            resList = new ArrayList<>();
        }

        orderByMidTraversal(root.left, resList);
        resList.add(root.val);
        orderByMidTraversal(root.right, resList);
    }

    /**
     * @param root
     * @description 后序遍历
     */
    public static List<Integer> orderByBehindTraversal(TreeNode root) {
        List<Integer> preList = new ArrayList<>();
        if (root.left!=null) {
            List<Integer> leftList = orderByBehindTraversal(root.left);
            preList.addAll(leftList);
        }

        if (root.right!=null) {
            List<Integer> rightList = orderByBehindTraversal(root.right);
            preList.addAll(rightList);
        }

        preList.add(root.val);

        return preList;
    }
    /**
     * @param root
     * @description 后序遍历
     */
    public static void orderByBehindTraversal(TreeNode root, List<Integer> preList) {
        if (root == null) {
            return;
        }

        orderByBehindTraversal(root.left, preList);
        orderByBehindTraversal(root.right, preList);
        preList.add(root.val);
    }

    /**
     * @description 获得最小堆
     * @param arrays
     */
    public static int[] treeNodeToMinHeap(int[] arrays) {
        int[] processArrays = arrays.clone();
        int index = arrays.length/2;
        while (index>=0) {
            index = treeNodeConversion(processArrays, index);
        }
        return processArrays;
    }

    /**
     * @description 数组节点交换后，返回需要更改的节点下标。
     * @param arrays
     * @param index
     * @return
     */
    private static int treeNodeConversion(int[] arrays, int index) {
        int flagIndex = index-1;
        if (index>=arrays.length/2) {
            return Math.min(flagIndex, arrays.length/2-1);
        }

        //当前节点
        int left = (index<<1) +1;
        int right = left+1;
        //找到最小节点
        int indexMid = left;
        if (right<arrays.length) {
            indexMid = arrays[left] < arrays[right] ? left : right;
        }
        if (arrays[index]>arrays[indexMid]) {
            int temp = arrays[index];
            arrays[index] = arrays[indexMid];
            arrays[indexMid] = temp;
            flagIndex = indexMid;
        }
        return flagIndex;
    }

    public static List<Integer> breadConversion(TreeNode root) {

        QueueUtil queue = new QueueUtil();
        if (root==null) {
            return null;
        } else {
            queue.push(root);
        }
        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode head = (TreeNode)queue.pop();
            if (head==null) {
                continue;
            }
            res.add(head.val);
            queue.push(head.left);
            queue.push(head.right);
        }
        return res;
    }

}
