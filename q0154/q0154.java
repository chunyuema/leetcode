class Solution {
    public int findMin(int[] nums) {
        return dcHelper(nums, 0, nums.length - 1);
    }

    public int dcHelper(int[] nums, int l, int r) {
        // base case
        if (l + 1 >= r) {
            return Math.min(nums[l], nums[r]);
        }

        if (nums[l] < nums[r])
            return nums[l];

        // recursive case
        int m = l + (r - l) / 2;
        int min1 = dcHelper(nums, l, m - 1);
        int min2 = dcHelper(nums, m, r);
        return Math.min(min1, min2);
    }
}