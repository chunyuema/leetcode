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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        if (root == null) return view; 
        
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            view.add(queue.getLast().val);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        
        return view;
    }
}