class Solution {
    public int maxLevelSum(TreeNode root) {
        int currMaxSum = root.val;
        int maxSumLevel = 1;
        int currLevel = 1;

        Deque<TreeNode> q = new ArrayDeque<TreeNode>();
        q.offer(root);

        while (!q.isEmpty()) {
            int n = q.size();
            int levelSum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                levelSum += node.val;
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }

            if (levelSum > currMaxSum) {
                currMaxSum = levelSum;
                maxSumLevel = currLevel;
            }
            currLevel++;
        }

        return maxSumLevel;
    }
}