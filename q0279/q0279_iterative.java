class Solution {
    public int numSquares(int n) {
        // Let dp[i] represent the least number of perfect squares that sum to i
        int[] dp = new int[n + 1];

        // Initialize the dp array: dp[0] = 0 since 0 consists of 0 perfect square
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            // Loop through every possible perfect square numbers less than or equal to n
            for (int j = 1; j < (int)(Math.sqrt(i)) + 1; j++) {
                int prevPerfectSqaure = j * j;
                dp[i] = Math.min(dp[i], dp[i-prevPerfectSqaure] + 1);
            }
        }

        return dp[n];
    }
}