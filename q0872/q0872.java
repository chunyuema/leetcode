class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // Call DFS to get the leaves of tree 1:
        List<Integer> tree1Leaves = new ArrayList<>();
        dfsHelper(root1, tree1Leaves);

        // Call DFS to get the leaves of tree 2:
        List<Integer> tree2Leaves = new ArrayList<>();
        dfsHelper(root2, tree2Leaves);

        // Compare if the leaves are the same
        return tree1Leaves.equals(tree2Leaves);
    }

    // dfsHelper to get all the leave values
    private void dfsHelper(TreeNode node, List<Integer> leaves) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }
        dfsHelper(node.left, leaves);
        dfsHelper(node.right, leaves);
    }
}