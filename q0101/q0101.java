class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return dfsHelper(root.left, root.right);
    }

    private boolean dfsHelper(TreeNode n1, TreeNode n2) {
        // base case
        if (n1 == null && n2 == null)
            return true;
        if (n1 == null || n2 == null)
            return false;
        if (n1.val != n2.val)
            return false;

        // recursive case
        return dfsHelper(n1.left, n2.right) && dfsHelper(n1.right, n2.left);
    }
}