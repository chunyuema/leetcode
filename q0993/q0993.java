class Solution {
    private TreeNode xParent;
    private TreeNode yParent;
    private int xDepth;
    private int yDepth;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfsHelper(root, null, 0, x, y);
        return xDepth == yDepth && xParent != yParent;
    }

    private void dfsHelper(TreeNode node, TreeNode parent, int depth, int x, int y) {
        if (node == null)
            return;

        // update the parent and depth of x if we manage to find x
        if (node.val == x) {
            xParent = parent;
            xDepth = depth;
        }

        // update the parent and depth of y if we manage to find y
        if (node.val == y) {
            yParent = parent;
            yDepth = depth;
        }

        // dfsHelper will be invoked on the left and right subtree
        dfsHelper(node.left, node, depth + 1, x, y);
        dfsHelper(node.right, node, depth + 1, x, y);
    }
}