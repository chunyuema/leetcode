class Solution {
    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dpHelper(nums, nums.length - 1, memo);
    }

    private boolean dpHelper(int[] nums, int i, int[] memo) {
        // base case: if i == 0; trivially return true
        if (i == 0)
            return true;

        // memoization case: if memo[i] != 0, this means that we have explored it before
        // if memo[i] is 1 then we can reach it, otherwise, we cannot reach it
        if (memo[i] != -1)
            return (memo[i] == 1);

        // for all previous place that can jump to i, recursively check if anyone of
        // them can be reached.
        for (int j = 0; j < i; j++) {
            if (j + nums[j] >= i && dpHelper(nums, j, memo)) {
                memo[i] = 1;
                return true;
            }
        }
        memo[i] = 0;
        return false;
    }
}