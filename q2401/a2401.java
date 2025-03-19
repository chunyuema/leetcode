class Solution {
    public int longestNiceSubarray(int[] nums) {
        int currUsedBits = 0;  // Tracks the OR of all numbers in the current window
        int res = 1;  // The longest nice subarray found so far (at least 1)
        int l = 0;  // Left pointer of the sliding window
        
        // Iterate over the array with the right pointer (r)
        for (int r = 0; r < nums.length; r++) {
            // Try expanding the window by adding nums[r]
            while ((currUsedBits & nums[r]) != 0) {
                // If nums[r] has common bits with the current window, shrink from the left
                currUsedBits ^= nums[l];
                l++;
            }
            
            // Add nums[r] into the window
            currUsedBits |= nums[r];

            // Update the maximum length of the nice subarray
            res = Math.max(res, r - l + 1);
        }
        
        return res;
    }
}
