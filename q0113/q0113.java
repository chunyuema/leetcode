class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfsHelper(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    private void dfsHelper(TreeNode node, int diffToTarget, List<Integer> path, List<List<Integer>> res) {
        if (node == null)
            return;

        // Add the current node to the path
        path.add(node.val);

        // If current node satisfy the condition, add it to the solution set
        if (node.left == null && node.right == null && diffToTarget == node.val) {
            res.add(new ArrayList<>(path));
        }

        // Recursively explore the left and the right subtree
        dfsHelper(node.left, diffToTarget - node.val, path, res);
        dfsHelper(node.right, diffToTarget - node.val, path, res);

        // Remove the current node from the path (backtracking)
        path.remove(path.size() - 1);
    }
}