// 判断一棵二叉树是否是对称二叉树
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } 
        return help(root.left, root.right);
    }
    boolean help(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == null && right == null;
        } else {
            if (left.val != right.val) {
                return false;
            }
            return help(left.right, right.left) && help(left.left, right.right);
        }
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
