package main.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: java-code-study
 * @description: 二叉树的前序遍历
 * @author: zijie.zeng
 * @create: 2020-04-01 16:47
 */
public class TraversalPre {
    public static void main(String[] args) {
        testTreePreTraversal();
    }
    public static void testTreePreTraversal() {
        TreeNode tn = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        left.right = new TreeNode(4);
        TreeNode right = new TreeNode(3);
        tn.left = left;
        tn.right = right;

        List<Integer> res = preorderTraversal(tn);
        System.out.println("result is :" + res.toString());
    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> listRes = new ArrayList<>();

        if (root == null) {
            return listRes;
        }

        listRes.add(root.val);
        List<Integer> midTreeValue;
        if (root.left!=null) {
            midTreeValue = preorderTraversal(root.left);
            listRes.addAll(midTreeValue);
        }
        if (root.right!=null) {
            midTreeValue = preorderTraversal(root.right);
            listRes.addAll(midTreeValue);
        }

        return listRes;
    }
}
