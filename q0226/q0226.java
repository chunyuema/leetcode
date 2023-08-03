class Solution {
    public TreeNode invertTree(TreeNode root) {
        dfsHelper(root);
        return root;
    }

    private void dfsHelper(TreeNode node) {
        if (node == null)
            return;

        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        dfsHelper(node.left);
        dfsHelper(node.right);
    }
}