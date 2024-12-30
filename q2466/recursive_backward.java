class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        memo = new int[high + 1];
        Arrays.fill(memo, -1);

        // count of the good strings = sum of all strings satisfying the condition
        int count = 0;
        for (int targetLen = low; targetLen <= high; targetLen++) {
            count += dpHelper(zero, one, targetLen);
            count %= MOD;
        }
        return count;
    }

    private static final int MOD = 1_000_000_007;
    private int[] memo;

    // Let dpHelper return the number of ways to reach target length
    private int dpHelper(int zero, int one, int targetLen) {
        // Base case: 
        // If target len = 0, there is only 1 way to get there
        if (targetLen == 0) return 1; 
        // If target len < 0, there is no way to get there
        if (targetLen < 0) return 0;

        // Memoized case
        if (memo[targetLen] != -1) return memo[targetLen];

        // Recursive cases: 
        int totalCount = 0;
        // Option 1: To get to target length, we came from targetLen - zero
        totalCount += dpHelper(zero, one, targetLen - zero);
        // Option 2: To get to target length, we came from targetLen - one
        totalCount += dpHelper(zero, one, targetLen - one);

        // Cache the result
        memo[targetLen] = totalCount % MOD;
        return memo[targetLen];
    } 
}
