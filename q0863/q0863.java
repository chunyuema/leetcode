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

        // build the graph representation of the the tree
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildGraphFromTree(root, null, graph);

        // perform dfs on the tree to gather all the nodes k distance away from the
        // target
        List<Integer> res = new ArrayList<>();
        Set<TreeNode> visitedNode = new HashSet<>();
        visitedNode.add(target);
        dfsHelper(target, 0, k, res, visitedNode, graph);

        return res;
    }

    private void dfsHelper(TreeNode currNode, int distanceFromTarget, int k, List<Integer> res,
            Set<TreeNode> visitedNode, Map<TreeNode, List<TreeNode>> graph) {

        // base case: if the distance from the target is equal to k, add the current
        // node to the result set
        if (distanceFromTarget == k) {
            res.add(currNode.val);
            return;
        }

        // recursively call dfs on all of the neighbor nodes of the current node with
        // distance from target + 1
        for (TreeNode n : graph.getOrDefault(currNode, new ArrayList<>())) {
            if (!visitedNode.contains(n)) {
                visitedNode.add(n);
                dfsHelper(n, distanceFromTarget + 1, k, res, visitedNode, graph);
            }
        }
    }

    private void buildGraphFromTree(TreeNode currNode, TreeNode parentNode, Map<TreeNode, List<TreeNode>> graphedTree) {
        // only add the current node and parent node if both of them are not null
        if (currNode != null && parentNode != null) {
            graphedTree.computeIfAbsent(currNode, k -> new ArrayList<>()).add(parentNode);
            graphedTree.computeIfAbsent(parentNode, k -> new ArrayList<>()).add(currNode);
        }

        // recursively build tree from the left subtree
        if (currNode.left != null) {
            buildGraphFromTree(currNode.left, currNode, graphedTree);
        }

        // recursively build tree from the right subtree
        if (currNode.right != null) {
            buildGraphFromTree(currNode.right, currNode, graphedTree);
        }
    }
}