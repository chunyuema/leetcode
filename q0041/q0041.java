class Solution {
    public int firstMissingPositive(int[] nums) {
        // check if 1 is present and return 1 if it is not present
        boolean isOnePresent = false;
        for (int num : nums) {
            if (num == 1)
                isOnePresent = true;
        }
        if (!isOnePresent)
            return 1;

        // use 1 to replace all 0, negative integers, and out of range integers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length)
                nums[i] = 1;
        }

        // flip the numbers to negative based on index
        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            // only flip once to avoid duplicated processing
            if (nums[idx] > 0)
                nums[idx] *= -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                return i + 1;
        }
        return nums.length + 1;
    }
}