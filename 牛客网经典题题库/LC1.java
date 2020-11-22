// 二叉树的最小深度
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null ||  root.right == null) {
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        }  else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
