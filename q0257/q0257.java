package q0257;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        getPaths(root, res, "");
        return res;
    }

    private void getPaths(TreeNode node, ArrayList<String> res, String currPath) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            res.add(currPath + String.valueOf(node.val));
            return;
        }
        getPaths(node.left, res, currPath + String.valueOf(node.val) + "->");
        getPaths(node.right, res, currPath + String.valueOf(node.val) + "->");
    }
}