class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int maxLenIncrease = 1; // Maximum length of wiggle subsequence ending with an increasing wiggle
        int maxLenDecrease = 1; // Maximum length of wiggle subsequence ending with a decreasing wiggle

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                // If current number is greater than previous, it extends the increasing sequence
                maxLenIncrease = maxLenDecrease + 1;
            } else if (nums[i] < nums[i-1]) {
                // If current number is less than previous, it extends the decreasing sequence
                maxLenDecrease = maxLenIncrease + 1;
            }
            // If nums[i] == nums[i-1], both sequences remain the same length
        }

        // Return the maximum of the two lengths
        return Math.max(maxLenIncrease, maxLenDecrease);
    }
}
