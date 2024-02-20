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

class FindElements {
    private Set<Integer> valueSet = new HashSet<>();

    public FindElements(TreeNode root) {
        if (root == null)
            return;
        valueSet.add(0);
        recoverTree(root.left, 0, true);
        recoverTree(root.right, 0, false);
    }

    public boolean find(int target) {
        return valueSet.contains(target);
    }

    private void recoverTree(TreeNode node, int parentVal, boolean isLeftChild) {
        if (node == null)
            return;

        // Compute the recovered value for current node
        node.val = parentVal * 2 + (isLeftChild ? 1 : 2);
        valueSet.add(node.val);

        // Recursively recover the left sub tree
        recoverTree(node.left, node.val, true);

        // Recursively recover the right sub tree
        recoverTree(node.right, node.val, false);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */