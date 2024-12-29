class Solution {
    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dpHelper(nums, 0, memo);
    }

    // dpHelper(i) return if you could jump from index i to the end of the array
    private boolean dpHelper(int[] nums, int i, int[] memo) {
        // Base case: if i is already at the end, return true
        if (i == nums.length - 1) return true;

        // Memoized case: if dpHelper(i) has been checked before, return previous result
        if (memo[i] != -1) return memo[i] == 1;
        
        // Recursive case: for all the j's that you can reach from i, recursively check if dpHelper(j) is true
        for (int j = i + 1; j <= Math.min(nums.length-1, i + nums[i]); j++) {
	    // If any of the index j can reach the end of the array, return true
            if (dpHelper(nums, j, memo)) {
                memo[i] = 1;
                return true;
            }
        }
	// Cache the solution for furture references
        memo[i] = 0;
	// Explored all the j's, and none of them could reach the end of the array, return false
        return false;
    }
}
