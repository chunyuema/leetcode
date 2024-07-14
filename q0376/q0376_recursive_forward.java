class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        // Memoization array to store results of subproblems
        int[][] memo = new int[nums.length][2];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // Initialize with -1 indicating not computed yet
        }
        
        int maxLength = 1; // At least one element can be a wiggle sequence
        
        // Iterate through each index and calculate the maximum wiggle sequence length starting from there
        for (int i = 0; i < nums.length; i++) {
            maxLength = Math.max(maxLength, Math.max(dpHelper(nums, i, true, memo), dpHelper(nums, i, false, memo)));
        }
        
        return maxLength;
    }
    
    // Recursive helper function with memoization
    private int dpHelper(int[] nums, int start, boolean isIncreasing, int[][] memo) {
        if (memo[start][isIncreasing ? 1 : 0] != -1) {
            return memo[start][isIncreasing ? 1 : 0]; // Return memoized result if already computed
        }
        
        int maxLength = 1; // Minimum wiggle subsequence length starting from any index is 1
        
        // Traverse through the array starting from 'start' index
        for (int i = start + 1; i < nums.length; i++) {
            if ((isIncreasing && nums[i] > nums[start]) || (!isIncreasing && nums[i] < nums[start])) {
                // If current number can be part of a valid wiggle sequence
                maxLength = Math.max(maxLength, 1 + dpHelper(nums, i, !isIncreasing, memo));
            }
        }
        
        // Memoize the result
        memo[start][isIncreasing ? 1 : 0] = maxLength;
        
        return maxLength;
    }
}
