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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int currLevel = 0;
        while (!queue.isEmpty()) {
            int currLevelNodeCount = queue.size();
            int prevNodeVal = (currLevel % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < currLevelNodeCount; i++) {
                TreeNode currNode = queue.poll();
                if (currLevel % 2 == 0) {
                    if (currNode.val % 2 == 0)
                        return false;
                    else if (currNode.val <= prevNodeVal)
                        return false;
                } else {
                    if (currNode.val % 2 != 0)
                        return false;
                    else if (currNode.val >= prevNodeVal)
                        return false;
                }
                prevNodeVal = currNode.val;
                if (currNode.left != null)
                    queue.offer(currNode.left);
                if (currNode.right != null)
                    queue.offer(currNode.right);
            }
            currLevel++;
        }
        return true;
    }
}