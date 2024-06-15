class Solution {
    public int findDuplicate(int[] nums) {
        for (int num : nums) {
            int idx = Math.abs(num);
            if (nums[idx - 1] < 0) {
                return idx;
            }
            nums[idx - 1] *= -1;
        }
        return -1;
    }
}
