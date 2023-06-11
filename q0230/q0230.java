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
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> node_stack = new LinkedList<>();
        while (true) {
            while (root != null) {
                node_stack.push(root);
                root = root.left;
            }
            root = node_stack.pop();
            k--;
            if (k == 0)
                return root.val;
            root = root.right;
        }
    }
}