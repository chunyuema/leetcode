class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dpHelper(n, memo);
    }

    // Let dpHelper return the number of ways to reach n
    private int dpHelper(int n, int[] memo) {

        // Base cases
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;

        // Memoized case
        if (memo[n] != -1)
            return memo[n];

        // Recursive case
        int res = dpHelper(n - 1, memo) + dpHelper(n - 2, memo);

        // Memoization
        memo[n] = res;
        return res;
    }
}