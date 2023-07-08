class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0;
        int r = 0; 
        int maxLen = 0;
        int totalZeros = 0;
        while (r < nums.length) {
            totalZeros += (nums[r] == 0 ? 1 : 0);
            
            while (totalZeros > 1) {
                totalZeros -= (nums[l] == 0 ? 1 : 0);
                l++;
            }

            maxLen = Math.max(maxLen, r - l);
            r++;
        }
        return maxLen;
    }
}