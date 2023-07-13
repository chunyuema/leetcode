/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, List<TreeNode>> graphedTree = new HashMap<>();
        buildGraphFromTree(root, null, graphedTree);

        List<Integer> res = new ArrayList<>();
        Set<TreeNode> visitedNode = new HashSet<>();
        visitedNode.add(target);
        dfsHelper(target, 0, k, res, visitedNode, graphedTree);

        return res;
    }

    private void dfsHelper(TreeNode currNode, int distanceFromTarget, int k, List<Integer> res,
            Set<TreeNode> visitedNode, Map<TreeNode, List<TreeNode>> graphedTree) {
        if (distanceFromTarget == k) {
            res.add(currNode.val);
            return;
        }

        for (TreeNode n : graphedTree.getOrDefault(currNode, new ArrayList<>())) {
            if (!visitedNode.contains(n)) {
                visitedNode.add(n);
                dfsHelper(n, distanceFromTarget + 1, k, res, visitedNode, graphedTree);
            }
        }
    }

    private void buildGraphFromTree(TreeNode currNode, TreeNode parentNode, Map<TreeNode, List<TreeNode>> graphedTree) {
        if (currNode != null && parentNode != null) {
            graphedTree.computeIfAbsent(currNode, k -> new ArrayList<>()).add(parentNode);
            graphedTree.computeIfAbsent(parentNode, k -> new ArrayList<>()).add(currNode);
        }
        if (currNode.left != null) {
            buildGraphFromTree(currNode.left, currNode, graphedTree);
        }

        if (currNode.right != null) {
            buildGraphFromTree(currNode.right, currNode, graphedTree);
        }
    }
}