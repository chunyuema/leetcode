class Solution {
    public int maxSubArray(int[] nums) {
        // Let dp[i] represent the maxSum ending at the index i
        int[] dp = new int[nums.length];

        // Base case
        dp[0] = nums[0];

        // Max sum of a contiguous subarray = the maximum sum of subarrays ending at each position.
        int maxSum = nums[0]; 
        for (int i = 1; i < nums.length; i++) {
            // Update the dp array
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            // Update the global maxSum
            maxSum = Math.max(dp[i], maxSum);
        }
        return maxSum;
    }
}