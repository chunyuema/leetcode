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
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode node, StringBuilder currString) {
        // base case 1
        if (node == null)
            return;

        currString.append(node.val);

        // base case 2
        if (node.left == null && node.right == null)
            return;

        // recurse on the left
        currString.append("(");
        dfs(node.left, currString);
        currString.append(")");

        // recurse on the right
        if (node.right != null) {
            currString.append("(");
            dfs(node.right, currString);
            currString.append(")");
        }
    }
}