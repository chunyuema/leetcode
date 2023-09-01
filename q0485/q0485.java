class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int maxLen = dp[0];
        for (int i = 1; i < nums.length; i++) {
            // if we see 1, then try to extend from dp(i-1) because the 1's have to be consecutive
            if (nums[i] == 1) {
                dp[i] = 1 + dp[i-1];
                // update maxLen only if we have a potential candidate
                maxLen = Math.max(maxLen, dp[i]);
            }
            // else: nums[i] == 0, no ops
        }
        return maxLen;
    }
}