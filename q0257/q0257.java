class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        dfsHelper(root, res, "");
        return res;
    }

    private void dfsHelper(TreeNode node, ArrayList<String> res, String currPath) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            res.add(currPath + String.valueOf(node.val));
            return;
        }
        dfsHelper(node.left, res, currPath + String.valueOf(node.val) + "->");
        dfsHelper(node.right, res, currPath + String.valueOf(node.val) + "->");
    }
}