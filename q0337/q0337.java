class Solution {
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> parentRobbedMemo = new HashMap<>();
        Map<TreeNode, Integer> parentNotRobbedMemo = new HashMap<>();
        return dpHelper(root, false, parentRobbedMemo, parentNotRobbedMemo);
    }

    private int dpHelper(TreeNode node, boolean isParentRobbed, Map<TreeNode, Integer> parentRobbedMemo,
            Map<TreeNode, Integer> parentNotRobbedMemo) {
        if (node == null)
            return 0;

        if (isParentRobbed) {
            if (parentRobbedMemo.containsKey(node))
                return parentRobbedMemo.get(node);
            int res = dpHelper(node.left, false, parentRobbedMemo, parentNotRobbedMemo)
                    + dpHelper(node.right, false, parentRobbedMemo, parentNotRobbedMemo);
            parentRobbedMemo.put(node, res);
            return res;
        } else {
            if (parentNotRobbedMemo.containsKey(node))
                return parentNotRobbedMemo.get(node);
            int sol1 = node.val + dpHelper(node.left, true, parentRobbedMemo, parentNotRobbedMemo)
                    + dpHelper(node.right, true, parentRobbedMemo, parentNotRobbedMemo);
            int sol2 = dpHelper(node.left, false, parentRobbedMemo, parentNotRobbedMemo)
                    + dpHelper(node.right, false, parentRobbedMemo, parentNotRobbedMemo);
            int res = Math.max(sol1, sol2);
            parentNotRobbedMemo.put(node, res);
            return res;
        }
    }
}
