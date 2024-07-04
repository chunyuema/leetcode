class Solution {
    public int numSquares(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        return dpHelper(n, memo);
    }

    // dpHelper(n) returns the minimal number of perfect squares that sums to n
    private int dpHelper(int n, int[] memo) {
        // Base case: since 0 consists of 0 perfect square
        if (n == 0) return 0; 

        // Memoized step
        if (memo[n] != Integer.MAX_VALUE) return memo[n];

        // Loop through all possible perfect square less than n
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < (int)(Math.sqrt(n)) + 1; i++) {
            int prevPerfectSquare = i * i;
            res = Math.min(res, 1 + dpHelper(n - prevPerfectSquare, memo));
        }
        memo[n] = res;
        return res;
    }
}