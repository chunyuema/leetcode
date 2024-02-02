class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        // return the max money robbed when the robber finishes
        return dpHelper(nums, nums.length - 1, memo);
    }

    // dp(i) represents the maximum amount of money collected until index i
    private int dpHelper(int[] nums, int i, int[] memo) {

        // base case:
        if (i == 0)
            return nums[0];
        if (i == 1)
            return Math.max(nums[0], nums[1]);

        // memoized case:
        if (memo[i] != -1)
            return memo[i];

        // recursive case:
        // case 1: rob the current house, money can only be added to the dp(i-2)
        int rob = dpHelper(nums, i - 2, memo) + nums[i];

        // case 2: do not rob the current house, total money stays unchanged dp(i-1)
        int noRob = dpHelper(nums, i - 1, memo);
        memo[i] = Math.max(rob, noRob);
        return memo[i];
    }
}