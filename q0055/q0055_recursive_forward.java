class Solution {
    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dpHelper(nums, 0, memo);
    }

    // dpHelper(i) return the min number to jump to nums[n-1], if you start from index i
    private boolean dpHelper(int[] nums, int i, int[] memo) {
        // Base case: if i is already at the end
        if (i == nums.length - 1) return true;

        // Memoized case: if dpHelper(i) has been computed before
        if (memo[i] != -1) return memo[i] == 1;
        
        // Recursive case: for all the j's that you can reach from i, recursively check if dpHelper(j) is true
        for (int j = i + 1; j <= Math.min(nums.length-1, i + nums[i]); j++) {
            if (dpHelper(nums, j, memo)) {
                memo[i] = 1;
                return true;
            }
        }
        memo[i] = 0;
        return false;
    }
}