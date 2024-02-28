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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode currNode = root;
        queue.offer(currNode);
        while (!queue.isEmpty()) {
            currNode = queue.poll();
            // Add from the right to the left to ensure that that last node processed
            // Is the left most node within the level
            if (currNode.right != null)
                queue.offer(currNode.right);
            if (currNode.left != null)
                queue.offer(currNode.left);
        }
        return currNode.val;
    }
}