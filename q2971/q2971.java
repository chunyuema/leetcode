class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long runningSum = nums[0] + nums[1];
        long res = -1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < runningSum) {
                res = nums[i] + runningSum;
            }
            runningSum += nums[i];
        }
        return res;
    }
}