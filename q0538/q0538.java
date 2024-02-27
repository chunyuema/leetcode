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
    private int currSum = 0;

    public TreeNode convertBST(TreeNode root) {
        dfsHelper(root);
        return root;
    }

    private void dfsHelper(TreeNode node) {
        if (node == null)
            return;
        dfsHelper(node.right);
        currSum += node.val;
        node.val = currSum;
        dfsHelper(node.left);
        return;
    }
}