class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if (r == 0 || nums[r] >= nums[l]) {
            return nums[0];
        }

        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[m + 1])
                return nums[m + 1];
            if (nums[m] < nums[m - 1])
                return nums[m];
            if (nums[m] > nums[0])
                l = m + 1;
            if (nums[m] < nums[0])
                r = m - 1;
        }
        return -1;
    }
}