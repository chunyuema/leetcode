/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private String smallest;

    public String smallestFromLeaf(TreeNode root) {
        smallest = "";
        dfs(root, "");
        return smallest;
    }

    private void dfs(TreeNode node, String currString) {
        if (node == null) return;

        currString = (char)(node.val + 'a') + currString;
        if (node.left == null && node.right == null) {
            if (smallest.length() == 0 || smallest.compareTo(currString) > 0) {
                smallest = currString;
            }
        }

        dfs(node.left, currString);
        dfs(node.right, currString);
    }
}