package main.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: java-code-study
 * @description: 二叉树学习
 * @author: zijie.zeng
 * @create: 2020-01-15 23:54
 */
public class TwoTreeStudy {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);

        TreeNode rootNode = getTreeNode(arrayList, 0);

        System.out.println("===========");

    }

    /**
     * @description 生成二叉树
     * @param arrayList
     * @param index
     * @return
     */
    public static TreeNode getTreeNode(List<Integer> arrayList, int index) {
        if (arrayList.size()<index+1||arrayList.get(index)==null) {
            return null;
        }
        TreeNode treeNode = new TreeNode(arrayList.get(index));

        TreeNode leftNode = getTreeNode(arrayList, index*2+1);

        TreeNode rightNode = getTreeNode(arrayList, index*2+2);

        treeNode.left = leftNode;
        treeNode.right = rightNode;
        return treeNode;
    }

}
