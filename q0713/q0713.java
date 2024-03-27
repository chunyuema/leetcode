class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int windowProduct = 1;

        int res = 0;
        for (int right = 0; right < nums.length; right++) {
            // expand the window to include the new number
            windowProduct *= nums[right];

            // shrink the window until the window product meets requirement
            while (left <= right && windowProduct >= k) {
                windowProduct /= nums[left];
                left++;
            }

            // increment the result
            res += right - left + 1;
        }
        return res;
    }
}