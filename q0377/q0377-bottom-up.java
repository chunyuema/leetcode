class Solution {
    public int combinationSum4(int[] nums, int target) {
        // dp[i] denotes the # of combinations that give the sum of i
        int[] dp = new int[target + 1];
        
        // initializa the base case: # of combinations with sum 0 is 1
        dp[0] = 1;

        // for any sum i, the recurrence relation is that dp[i] = sum(dp[i - num])
        // num represents all the possible numbers from nums
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                int prevSum = i - num;
                // note that we only update if i - num is not less than zero
                dp[i] += (prevSum >= 0) ? dp[prevSum] : 0;
            }
        }
        return dp[target];
    }
}