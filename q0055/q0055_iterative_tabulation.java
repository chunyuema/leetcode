class Solution {
    public boolean canJump(int[] nums) {
        // Let dp[i] represent if index i is reachable
	int[] dp = new int[nums.length];
        dp[0] = 1;

	// For every index i, to check if index i is reachable: 
        for (int i = 0; i < nums.length; i++) {
	    // Check all index j (where j could reach i) and see if j is reachable
            for (int j = 0; j < i; j++) {
                if (dp[j] == 1 && j + nums[j] >= i) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[nums.length - 1] != 0;
    }
}
