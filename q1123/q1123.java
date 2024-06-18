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
    private TreeNode lca;
    private int deepest = 0;
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfsHelper(root, 0);
        return lca;
    }
    
    private int dfsHelper(TreeNode node, int currDepth) {
        deepest = Math.max(currDepth, deepest);
        
        if (node == null) return currDepth;
        
        int leftDepth = dfsHelper(node.left, currDepth + 1);
        int rightDepth = dfsHelper(node.right, currDepth + 1);
        
        if (leftDepth == rightDepth && leftDepth == deepest) {
            lca = node;
        }
        
        return Math.max(leftDepth, rightDepth);
    }
}