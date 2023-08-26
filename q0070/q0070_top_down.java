class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return dpHelper(n, memo);
    }

    private int dpHelper(int n, int[] memo) {
        // base cases
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (memo[n] != -1)
            return memo[n];

        // recursive case
        int res = dpHelper(n - 1, memo) + dpHelper(n - 2, memo);

        // store the res in memo
        memo[n] = res;
        return res;
    }
}