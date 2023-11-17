class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int minSum = Integer.MIN_VALUE;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            minSum = Math.max(minSum, nums[l] + nums[r]);
            l++;
            r--;
        }
        return minSum;
    }
}