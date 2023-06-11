class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int l = 0;
        int currSum = 0;
        for (int r = 0; r < nums.length; r++) {
            currSum += nums[r];
            while (currSum >= target) {
                minLen = Math.min(minLen, r - l + 1);
                currSum -= nums[l];
                l++;
            }
        }
        return (minLen != Integer.MAX_VALUE) ? minLen : 0;
    }
}