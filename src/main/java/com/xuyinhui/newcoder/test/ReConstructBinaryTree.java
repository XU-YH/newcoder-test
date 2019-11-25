/**
 * @author: xu_yh
 * @date: 2019/11/23 19:14
 * @Copyright ©2019 xu_yh. All rights reserved.
 */
package com.xuyinhui.newcoder.test;

import org.junit.Test;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @author: xu_yh
 * @date: 2019/11/23 19:14
 * @version: V1.0
 */
public class ReConstructBinaryTree {

    /**
     * 测试方法
     */
    @Test
    public void test() {
        int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
        // TreeNode treeNode = reConstructBinaryTree1(pre, in);
        TreeNode treeNode = reConstructBinaryTree2(pre, in);
    }

    /**
     * 解法二
     *
     * @param pre
     * @param in
     * @return
     */
    private TreeNode reConstructBinaryTree2(int[] pre, int[] in) {
        if (pre == null || 0 == pre.length) {
            return null;
        }
        TreeNode resultTree = reConstructBinaryTree2(pre, 0, pre.length - 1, in, 0, in.length - 1);

        return resultTree;
    }

    /**
     * 解法二：递归，不适用工具类，避免新数组的开销
     *
     * @param pre
     * @param startPre
     * @param startIn
     * @param in
     * @param endPre
     * @param endIn
     * @return
     */
    private TreeNode reConstructBinaryTree2(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode rootNode = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            // 找出根节点在中序遍历中的位置
            if (in[i] == rootNode.val) {
                int lenth = i - startIn;
                // 左子树
                rootNode.left = reConstructBinaryTree2(pre, startPre + 1, startPre + lenth, in, startIn,
                        startIn + lenth);
                // 右子树
                rootNode.right = reConstructBinaryTree2(pre, lenth + startPre + 1, endPre, in, startIn + lenth + 1,
                        endIn);
                break;
            }
        }

        return rootNode;
    }

    /**
     * 解法一：递归
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree1(int[] pre, int[] in) {
        if (pre == null || 0 == pre.length) {
            return null;
        }

        // 根节点在中序遍历中的位置
        int root;
        for (root = 0; root < in.length; root++) {
            if (pre[0] == in[root]) {
                break;
            }
        }
        TreeNode resultTree = new TreeNode(pre[0]);
        if (pre.length > 1) {
            resultTree.left = reConstructBinaryTree1(Arrays.copyOfRange(pre, 1, root + 1),
                    Arrays.copyOfRange(in, 0, root));
            resultTree.right = reConstructBinaryTree1(Arrays.copyOfRange(pre, root + 1, pre.length),
                    Arrays.copyOfRange(in, root + 1, pre.length));
        }

        return resultTree;
    }

}

/**
 * 树类
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}