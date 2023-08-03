class Solution {

    public TreeNode bstFromPreorder(int[] preOrderTraversalValues) {
        return dfsHelper(preOrderTraversalValues, 0, preOrderTraversalValues.length - 1);
    }

    public TreeNode dfsHelper(int[] preOrderTraversalValues, int l, int r) {
        if (l > r)
            return null;
        int rootVal = preOrderTraversalValues[l];
        int m = l;
        for (; m <= r; m++) {
            if (preOrderTraversalValues[m] > rootVal)
                break;
        }
        TreeNode left = dfsHelper(preOrderTraversalValues, l + 1, m - 1);
        TreeNode right = dfsHelper(preOrderTraversalValues, m, r);
        return new TreeNode(rootVal, left, right);
    }
}