class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
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