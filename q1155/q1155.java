class Solution {

    private final int MOD = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        int[][] memo = new int[n + 1][target + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return dpHelper(n, k, target, memo);
    }

    private int dpHelper(int n, int k, int target, int[][] memo) {
        // base case: if no more dice is left
        if (n == 0 && target == 0)
            return 1;
        if (n <= 0 || target < 0)
            return 0;

        // base case: if (n, target) has been computed,
        // (n, target) represent the number of ways to
        // construct target with n dice left
        if (memo[n][diff] != -1)
            return memo[n][diff];

        // recursive case
        int res = 0;
        for (int i = 1; i <= k; i++) {
            res = (res + dpHelper(n - 1, k, diff - i, memo)) % MOD;
        }

        // store in the memo
        memo[n][diff] = res;

        return res;
    }
}