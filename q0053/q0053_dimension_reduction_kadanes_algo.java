class Solution {
    public int maxSubArray(int[] nums) {
        // Max sum of a contiguous subarray = the maximum sum of subarrays ending at each position.
        int currMaxSum = nums[0]; 
        int globalMaxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // Update the dp array
            currMaxSum = Math.max(currMaxSum + nums[i], nums[i]);
            // Update the global maxSum
            globalMaxSum = Math.max(currMaxSum, globalMaxSum);
        }
        return globalMaxSum;
    }
}