/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private int maxDepth;
    private int leftmostVal;

    private void dfsHelper(TreeNode node, int currDepth) {
        if (node == null)
            return;

        // Base case:
        if (node.left == null && node.right == null && currDepth > maxDepth) {
            leftmostVal = node.val;
            maxDepth = currDepth;
        }

        // Recursive case:
        dfsHelper(node.left, currDepth + 1);
        dfsHelper(node.right, currDepth + 1);
    }

    public int findBottomLeftValue(TreeNode root) {
        maxDepth = 0;
        leftmostVal = root.val;
        dfsHelper(root, 0);
        return leftmostVal;
    }
}