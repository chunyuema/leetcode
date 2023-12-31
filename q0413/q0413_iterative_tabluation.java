class Solution {
    public int numberOfArithmeticSlices(int[] nums) {

        // dp[i] represents the number of arithmetic slices ending at i
        int[] dp = new int[nums.length];

        int res = 0;
        for (int i = 2; i < nums.length; i++) {

            // case 1: if a subarray can be formed
            if (nums[i - 1] - nums[i - 2] == nums[i] - nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }

            // case 2: if a subarray cannot be formed => implicit, not need to be coded up
            // else { dp[i] = 0; }

            // updating the final result to track the total number of arithmetic slices
            res += dp[i];
        }

        return res;
    }
};