class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            // important to get n as this is the number of nodes on the current level
            int n = q.size();
            List<Integer> currLevel = new ArrayList<>();
            // use n as the condition to terminate the loop
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                currLevel.add(node.val);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            res.add(currLevel);
        }
        return res;
    }
}