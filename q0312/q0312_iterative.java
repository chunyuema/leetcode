class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // Let dp[l][r] represent the maxCoins obtained for popping the subarray with left index at l, and right index at r
        int[][] dp = new int[n][n]; 

        // Iterate through all possible lengths
        for (int len = 0; len < n; len++) {
            // Iterate through all possible left index l
            for (int l = 0; l < n - len; l++) {
                int r = l + len;
                int leftBalloon = (l >= 1) ? nums[l - 1] : 1;
                int rightBalloon = (r < n - 1) ? nums[r + 1] : 1;

                // Iterate through the last balloon to be popped from l to r
                for (int i = l; i <= r; i++) {
                    int coins = leftBalloon * nums[i] * rightBalloon;
                    int leftCoins = (i == l) ? 0 : dp[l][i-1];
                    int rightCoins = (i == r) ? 0 : dp[i+1][r];
                    dp[l][r] = Math.max(dp[l][r], coins + leftCoins + rightCoins);
                } 
            }
        }

        return dp[0][n-1];
    }
}