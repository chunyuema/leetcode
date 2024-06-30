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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, inorder, 0, inorder.length-1);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int pl, int[] inorder, int il, int ir) {
        if (pl >= preorder.length || il > ir) return null;
        
        TreeNode root = new TreeNode(preorder[pl]);
        
        int rootIndex = 0;
        for (int i = il; i <= ir; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i; 
                break;
            }
        }
        
        root.left = buildTreeHelper(preorder, pl + 1, inorder, il, rootIndex-1);
        root.right = buildTreeHelper(preorder, pl + (rootIndex - il) + 1, inorder, rootIndex+1, ir);
        return root;
    }
}