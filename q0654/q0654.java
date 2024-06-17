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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructTree(nums, 0, nums.length);
    }
    
    private TreeNode constructTree(int[] nums, int l, int r) {
        if (l >= r) return null;
        
        // Find the current max index & use that as the root
        int maxIndex = findMaxIndex(nums, l, r);
        TreeNode root = new TreeNode(nums[maxIndex]);
        
        // Recursively build left and right subtree
        root.left = constructTree(nums, l, maxIndex);
        root.right = constructTree(nums, maxIndex+1, r);
        
        return root;
    }
    
    private int findMaxIndex(int[] nums, int l, int r) {
        int currMaxIndex = l;
        for (int i = l; i < r; i++) {
            if (nums[currMaxIndex] < nums[i]) {
                currMaxIndex = i;
            }
        }
        return currMaxIndex;
    }
}