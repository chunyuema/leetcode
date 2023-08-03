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
    private int currDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfsHelper(root);
        return currDiameter;
    }

    private int dfsHelper(TreeNode root) {
        if (root == null)
            return 0;
        int l = dfsHelper(root.left);
        int r = dfsHelper(root.right);
        currDiameter = Math.max(currDiameter, l + r);
        return Math.max(l, r) + 1;
    }
}