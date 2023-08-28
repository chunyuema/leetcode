class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inOrderTraversal(root, values);

        TreeNode dummy = new TreeNode(0);
        TreeNode temp = dummy;
        for (int i = 0; i < values.size(); i++) {
            temp.right = new TreeNode(values.get(i));
            temp = temp.right;
        }
        return dummy.right;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> values) {
        if (node == null) return;
        inOrderTraversal(node.left, values);
        values.add(node.val);
        inOrderTraversal(node.right, values);
    }
}