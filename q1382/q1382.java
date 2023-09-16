class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        inOrder(root, vals);
        return buildTree(vals, 0, vals.size() - 1);
    }

    private void inOrder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    private TreeNode buildTree(List<Integer> vals, int l, int r) {
        if (l > r)
            return null;
        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(vals.get(m));
        root.left = buildTree(vals, l, m - 1);
        root.right = buildTree(vals, m + 1, r);
        return root;
    }
}