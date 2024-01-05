class Solution {
    public int lengthOfLIS(int[] nums) {

        // Let dp[i] represent the max len of LIS ending at index i
        int[] dp = new int[nums.length];
        int maxLen = 1;
        Arrays.fill(dp, 1);

        // To compute the len of LIS ending at i
        for (int i = 0; i < nums.length; i++) {

            // Recurrence relation: dp[i] = max(dp[j] + 1) for all j (nums[i] > nums[j])
            // Loop through all possible j (j < i), and update the dp[i] accordingly
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            // Update the max len to return it at the end of the loop
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }
}