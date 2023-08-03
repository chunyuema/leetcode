class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfsHelper(root, targetSum);
    }

    private boolean dfsHelper(TreeNode node, int diffFromSum) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null)
            return node.val == diffFromSum;
        int newDiffFromSum = diffFromSum - node.val;
        return dfsHelper(node.left, newDiffFromSum) || dfsHelper(node.right, newDiffFromSum);
    }
}