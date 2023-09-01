class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        // To maximize the money, the robber must have been robbing all the way until the end
        return dpHelper(nums, nums.length-1, memo);
    }

    // Let dp(i) represent the maximum amount of money collected if the robber rob all the way until index i
    private int dpHelper(int[] nums, int i, int[] memo) {
        // base case: 
        if (i == 0) return nums[0];
        if (i == 1) return Math.max(nums[0], nums[1]);
        if (memo[i] != -1) return memo[i];

        // recursive case:
        // case 1: rob the current house, money can only be added to the dp(i-2)
        int rob = dpHelper(nums, i - 2, memo) + nums[i];
        // case 2: do not rob the current house, and the total money is the same as dp(i-1)
        int noRob = dpHelper(nums, i - 1, memo);
        memo[i] = Math.max(rob, noRob);
        return memo[i];
    }
}