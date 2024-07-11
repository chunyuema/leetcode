class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        // Create a 2D dp array with dimensions (nums1.length + 1) x (nums2.length + 1)
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        
        // Variable to store the maximum length of common subarray found
        int maxLen = 0; 
        
        // Iterate through each element in nums1 and nums2
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                // Check if current elements of nums1 and nums2 match
                if (nums1[i-1] == nums2[j-1]) {
                    // If they match, update dp[i][j] to be 1 plus dp[i-1][j-1]
                    dp[i][j] = 1 + dp[i-1][j-1];
                    // Update maxLen with the maximum value found in dp[i][j]
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        
        // Return the maximum length of common subarray found
        return maxLen;
    }
}
