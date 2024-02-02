class Solution {
    private final int mod = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // Let dp[i][j] represent the number of ways to reach after arbitrary moves
        int[][] dp = new int[m][n];
        // There is already 1 way of reaching the starting pos without moves
        dp[startRow][startColumn] = 1;

        int totalPaths = 0;
        // Loop through all the moves we have and simulate the board
        for (int move = 1; move <= maxMove; move++) {
            int[][] tmpDp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // If we reach border, the next step will be out,
                    // Add total number of ways to reach here to totalPaths
                    if (i == 0)
                        totalPaths = (totalPaths + dp[i][j]) % mod;
                    if (j == 0)
                        totalPaths = (totalPaths + dp[i][j]) % mod;
                    if (i == m - 1)
                        totalPaths = (totalPaths + dp[i][j]) % mod;
                    if (j == n - 1)
                        totalPaths = (totalPaths + dp[i][j]) % mod;

                    // Compute the total ways of reaching the current pos in move steps
                    // Moved into current pos from upper / lower row
                    // Moved into current pos from left / right column
                    tmpDp[i][j] = (((i > 0 ? dp[i - 1][j] : 0) + (i < m - 1 ? dp[i + 1][j] : 0)) % mod +
                            ((j > 0 ? dp[i][j - 1] : 0) + (j < n - 1 ? dp[i][j + 1] : 0)) % mod) % mod;
                }
            }
            dp = tmpDp;
        }
        return totalPaths;
    }
}