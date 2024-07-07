class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        
        for (int len = 3; len <= n; len++) {
            for (int start = 0; start + len - 1 < n; start++) {
                int end = start + len - 1;
                dp[start][end] = Integer.MAX_VALUE;
                for (int i = start + 1; i < end; i++) {
                    int score = values[start] * values[i] * values[end];
                    dp[start][end] = Math.min(dp[start][end], dp[start][i] + dp[i][end] + score);
                }
            }
        }
        
        return dp[0][n-1];
    }
}
