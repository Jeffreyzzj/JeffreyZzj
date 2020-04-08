package main.niuke;

import main.sort.TreeNode;

import java.util.ArrayList;

/**
 * @program: java-code-study
 * @description: 98. 验证二叉搜索树
 * @URL https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @author: zijie.zeng
 * @create: 2020-04-08 20:09
 */
public class CheckTreeNodeLeetCode {
    static Integer last = -Integer.MAX_VALUE;
    public static void main(String[] args) {
        preFun();
    }
    public static boolean preFun() {
        Integer[] arrayNodes = {1,null, 1};
        TreeNode root = TreeNode.createTreeNode(arrayNodes);
        boolean res = isValidBST(root);
        System.out.println("==");
        return res;
    }
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean res = isValidBST(root.left);

        //说明左子树正确
        if (res==true) {
            //比较中子数
            if (last<root.val) {
                last = root.val;
                return isValidBST(root.right);
            }
        }

        //中序遍历比较值失败，返回失败
        return false;
    }


    public static boolean checkTreeNode(TreeNode root) {
        boolean res = true;
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            if (root.left.val < root.val) {
                res = checkTreeNode(root.left);
                if (!res) {
                    return false;
                }
            } else {
                return false;
            }
        }

        if (root.right == null) {
            return true;
        }
        if (root.right.val > root.val) {
            res = checkTreeNode(root.right);
        } else {
            return false;
        }
        return res;
    }
}
