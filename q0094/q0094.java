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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfsHelper(root, res);
        return res;
    }

    private void dfsHelper(TreeNode node, List<Integer> vals) {
        if (node == null) {
            return;
        }
        dfsHelper(node.left, vals);
        vals.add(node.val);
        dfsHelper(node.right, vals);
    }
}