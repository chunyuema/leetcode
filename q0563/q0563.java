class Solution {
    private int totalTilt = 0;

    public int findTilt(TreeNode root) {
        dfsHelper(root);
        return totalTilt;
    }

    // This dfs helper function will return the sum of the tree rooted at node
    private int dfsHelper(TreeNode node) {
        if (node == null)
            return 0;
        int l = dfsHelper(node.left);
        int r = dfsHelper(node.right);

        // Update the total tilt variable while we are doing the DFS
        totalTilt += Math.abs(l - r);

        // Return the sum of the tree rooted at node
        return node.val + l + r;
    }
}