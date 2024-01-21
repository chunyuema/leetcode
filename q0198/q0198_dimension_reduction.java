class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        else if (n == 2)
            return Math.max(nums[0], nums[1]);

        // Max return until the previous previous house
        int prevPrevHouse = nums[0];
        // Max return until the previous house
        int prevHouse = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            // Max return until the current house
            int currHouse = Math.max(prevPrevHouse + nums[i], prevHouse);

            // Update the previouse house and previous previous house
            prevPrevHouse = prevHouse;
            prevHouse = currHouse;
        }

        return Math.max(prevPrevHouse, prevHouse);
    }
}