class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        memo = new int[high + 1];
        Arrays.fill(memo, -1);
        return dpHelper(low, high, zero, one, 0);
    }

    private static final int MOD = 1_000_000_007;
    private int[] memo;

    // Let dpHelper return the number of ways to get into the range given a current length
    private int dpHelper(int low, int high, int zero, int one, int currLen) {
        // Base case
        if (currLen > high) return 0;

        // Memoized case
        if (memo[currLen] != -1) return memo[currLen];

        // Recursive cases: 
        // First check if the current length is already satisfying the condition
        int totalCount = (currLen >= low && currLen <= high) ? 1 : 0;
        // Option 1: Append zeros and move forward
        int addZero = dpHelper(low, high, zero, one, currLen + zero);
        // Option 2: Append ones and move forward
        int addOne  = dpHelper(low, high, zero, one, currLen + one);

        // Cache the result
        memo[currLen] = (totalCount + addZero + addOne) % MOD;
        return memo[currLen];
    } 
}
