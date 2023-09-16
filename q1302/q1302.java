class Solution {
    public int deepestLeavesSum(TreeNode root) {
        dfsHelper(root, 0);
        return sum;
    }

    private void dfsHelper(TreeNode node, int currDepth) {
        if (node == null)
            return;

        // base case: if the current node is a leaf node:
        if (node.left == null && node.right == null) {
            // if the depth matches with the existing max depth => add value to the sum
            if (currDepth == depth) {
                sum += node.val;

                // if the depth is larger than the existing max depth => clear the sum with
                // value, and update the max depth
            } else if (currDepth > depth) {
                depth = currDepth;
                sum = node.val;
            }

            return;
        }

        // recursion case
        dfsHelper(node.left, currDepth + 1);
        dfsHelper(node.right, currDepth + 1);
    }

    private int sum = 0;
    private int depth = 0;
}