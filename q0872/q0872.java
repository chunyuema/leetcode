class Solution {
    private List<Integer> tree1Leaves = new ArrayList<>();
    private List<Integer> tree2Leaves = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfsHelper(root1, tree1Leaves);
        dfsHelper(root2, tree2Leaves);
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