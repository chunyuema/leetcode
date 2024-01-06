class Solution {
    public int maxProfit(int[] prices, int fee) {
        // Let dp(i, hasStock) represent the max profit until day i
        // hasStock indicates whether one has stock on day i or not
        int[][] dp = new int[2][prices.length];

        // Initialize the dp array. First day (without stock) maps to
        dp[0][0] = -1 * prices[0];
        dp[1][0] = 0;

        for (int i = 1; i < prices.length; i++) {
            // Case 1: has stock on day i
            // == has stock on day i-1 but did not sell
            // OR has no stock on day i-1 but buy on day i
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] - prices[i]);

            // Case 2: does not have stock on day i
            // == has no stock on day i-1 and does not buy
            // OR has stock on day i-1 but sell on day i
            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] + prices[i] - fee);
        }

        return Math.max(dp[0][prices.length - 1], dp[1][prices.length - 1]);
    }
}