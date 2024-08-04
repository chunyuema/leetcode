class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest we can reach from index i
            farthest = Math.max(farthest, i + nums[i]);

            // If we've reached the end of the current jump range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                
                // Early exit if we've reached or surpassed the last index
                if (currentEnd >= nums.length - 1) return jumps;
            }
        }

        return jumps;
    }
}