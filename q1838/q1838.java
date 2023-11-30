class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        long windowSum = 0;
        int res = 0;
        for (int right = 0; right < nums.length; right++) {

            // expand the window
            long newTarget = nums[right];
            windowSum += newTarget;

            // shrink the window to ensure tha conditions are not broken
            while (windowSum + k < (right - left + 1) * newTarget) {
                windowSum -= nums[left];
                left++;
            }

            // update the result after the
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}