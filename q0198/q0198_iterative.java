class Solution {
    public int rob(int[] nums) {
        // base cases
        int n = nums.length;
        if (n == 1)
            return nums[0];
        else if (n == 2)
            return Math.max(nums[0], nums[1]);

        // Let dp[i] represents the max return until the i-th house
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int prevPrevHouse = nums[i] + dp[i - 2];
            int prevHouse = dp[i - 1];
            dp[i] = Math.max(prevPrevHouse, prevHouse);
        }

        // Final return is dp[n-1] as the robber will consider until the last house
        return dp[n - 1];
    }
}