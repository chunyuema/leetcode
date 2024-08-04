class Solution {
    public int maxSubArray(int[] nums) {
        int[] memo = new int[nums.length];
        
        // Max sum of a contiguous subarray = the maximum sum of subarrays ending at each position.
        int maxSum = Integer.MIN_VALUE; 
        for (int i = 0; i < nums.length; i++) {
            maxSum = Math.max(dpHelper(nums, i, memo), maxSum);
        }
        return maxSum;
    }


    // Let dpHelper represent the max subarray ending at index i
    private int dpHelper(int[] nums, int i, int[] memo) {
        // Base case
        if (i == 0) return nums[0];

        // Memoized case
        if (memo[i] != 0) return memo[i];

        // Recursive case
        memo[i] = Math.max(dpHelper(nums, i-1, memo) + nums[i], nums[i]);

        return memo[i];
    }
}