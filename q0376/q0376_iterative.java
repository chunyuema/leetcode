class Solution {
    public int wiggleMaxLength(int[] nums) {
        // Let dp[0][i] represent the max len of the wiggle sequence until index i (nums[i] > nums[i-1])
        // Let dp[1][i] represent the max len of the wiggle sequence until index i (nums[i] < nums[i-1])
        int[][] dp = new int[2][nums.length];
        dp[0][0] = 1;
        dp[1][0] = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                dp[0][i] = dp[1][i-1] + 1;
                dp[1][i] = dp[1][i-1];
            } else if (nums[i] < nums[i-1]) {
                dp[0][i] = dp[0][i-1];
                dp[1][i] = dp[0][i-1] + 1;
            } else {
                dp[0][i] = dp[0][i-1];
                dp[1][i] = dp[1][i-1];
            }
        }
        return Math.max(dp[0][nums.length-1], dp[1][nums.length-1]);
    }
}