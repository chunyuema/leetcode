class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] memo = new int[nums.length + 1][nums.length + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        return dpHelper(nums, 0, -1, memo);
    }

    // Let dpHelper(currIndex, prevIndex) represent the max len of LIS if we start
    // at currIndex,
    // and with the prevIndex denoting the last index we included in the LIS
    private int dpHelper(int[] nums, int currIndex, int prevIndex, int[][] memo) {

        // base case: if there is no more num to consider, the max len of LIS is 0
        if (currIndex == nums.length)
            return 0;

        // memoization: if the max len of LIS with currIndex, prevIndex has been
        // calculated
        if (memo[currIndex][prevIndex + 1] != -1)
            return memo[currIndex][prevIndex + 1];

        // case 1: take the current index (if you can)
        int take = 0;
        if (prevIndex == -1 || nums[currIndex] > nums[prevIndex]) {
            take = 1 + dpHelper(nums, currIndex + 1, currIndex, memo);
        }

        // case 2: do not take the current index (whether you can or not)
        int noTake = dpHelper(nums, currIndex + 1, prevIndex, memo);

        memo[currIndex][prevIndex + 1] = Math.max(take, noTake);
        return memo[currIndex][prevIndex + 1];
    }
}