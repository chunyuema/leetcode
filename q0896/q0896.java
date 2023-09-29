class Solution {
    public boolean isMonotonic(int[] nums) {
        int monotonicStatus = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                if (monotonicStatus == -1)
                    return false;
                monotonicStatus = 1;
            } else if (nums[i] < nums[i - 1]) {
                if (monotonicStatus == 1)
                    return false;
                monotonicStatus = -1;
            }
        }
        return true;
    }
}