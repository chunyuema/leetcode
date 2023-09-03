class Solution {
    private int rangeSum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfsHelper(root, low, high);
        return rangeSum;   
    }

    private void dfsHelper(TreeNode node, int low, int high) {
        if (node == null) return;

        if (node.val >= low && node.val <= high) rangeSum += node.val;

        // if node.val is large than low, there could be some nodes in the left tree
        if (node.val > low) dfsHelper(node.left, low, high);
        // if node.val is less than high, there could be some nodes in the right tree
        if (node.val < high) dfsHelper(node.right, low, high);
    }
}