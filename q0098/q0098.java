class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfsHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfsHelper(TreeNode node, long min, long max) {
        if (node == null) return true;

        int currVal = node.val;
        // check if the current node val breaks the BST requirement
        if (currVal >= max || currVal <= min) return false;

        // recursively check if the left and the right subtree are also valid BST
        return dfsHelper(node.left, min, currVal) && dfsHelper(node.right, currVal, max);
    }
}