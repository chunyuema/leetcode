class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n + 1][3];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        // return dp(0, 0) as we want the max sum starting from index i with remainder 0
        // when divided by 3
        return dpHelper(nums, 0, 0, memo);
    }

    // let dp(i, remainder) represent the max sum you can build with max sum % 3 =
    // remainder starting from index i
    private int dpHelper(int[] nums, int i, int remainder, int[][] memo) {

        // base case: if i is len, then we are out of range
        if (i == nums.length) {
            // max sum having the remainder 0 is 0
            if (remainder == 0)
                return 0;
            // max sum having other remainder is impossible, return max small number
            return -10000;
        }

        // memoization step: if we have computed the max sum before, return it
        if (memo[i][remainder] != -1)
            return memo[i][remainder];

        // take the current number, update the remainder
        int newRemainder = (nums[i] % 3 + remainder) % 3;
        int take = nums[i] + dpHelper(nums, i + 1, newRemainder, memo);

        // do not take the current number, use old remainder
        int noTake = dpHelper(nums, i + 1, remainder, memo);

        memo[i][remainder] = Math.max(take, noTake);
        return memo[i][remainder];
    }
}