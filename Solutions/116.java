// 填充每个节点的下一个右侧节点指针，二叉树是完全二叉树
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int i = 0; i < size; ++i) {
                if (prev == null) {
                    prev = queue.poll();
                    if (prev.left != null) {queue.offer(prev.left);}
                    if (prev.right != null) {queue.offer(prev.right);}
                } else {
                    Node curr = queue.poll();
                    prev.next = curr;
                    prev = curr;
                    if (curr.left != null) {queue.offer(curr.left);}
                    if (curr.right != null) {queue.offer(curr.right);}
                }
            }
        }
        return root;
    }
}
