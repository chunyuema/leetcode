class Solution {
    public int climbStairs(int n) {
        // initialize dp array
        int[] dp = new int[n + 1];

        // initialize base cases
        dp[0] = 1;
        dp[1] = 1;

        // let dp[i] be number of ways to reach i
        // recurrence relation: dp[i] = dp[i-1] + dp[i-2]
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}