// 二叉树的锯齿状层次遍历
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int mark = 0;
    List<List<Integer>> list = new ArrayList<>();
    LinkedList<TreeNode> queue = new LinkedList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) return
            queue.add(root);
            while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int n = queue.size();
            for (int i = 0; i < n; i ++) {
                root = queue.removeFirst();
                if (mark == 0) level.addLast(root.val);
                else level.addFirst(root.val);
                if (root.left != null) queue.addLast(root.left);
                if (root.right != null) queue.addLast(root.right);
            }
            list.add(level);
            mark = 1 - mark;
        }
        return list;
    }
}
