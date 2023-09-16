class Solution {

    // track the max diff seen during DFS
    private int maxDiff = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfsHelper(root, root.val, root.val);
        return maxDiff;
    }

    private void dfsHelper(TreeNode node, int maxVal, int minVal) {
        // update the max diff based on the node, maxVal, and minVal we have seen
        if (node == null)
            return;
        int diff1 = Math.abs(node.val - maxVal);
        int diff2 = Math.abs(node.val - minVal);
        maxDiff = Math.max(Math.max(diff1, diff2), maxDiff);

        // update the maxVal and minVal
        maxVal = Math.max(node.val, maxVal);
        minVal = Math.min(node.val, minVal);

        // recurse on the left and right subtree
        dfsHelper(node.left, maxVal, minVal);
        dfsHelper(node.right, maxVal, minVal);
    }
}