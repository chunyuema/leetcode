class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        int maxLen = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    // Base case: If the current cell is on the border, then dp[i][j] = 1;
                    if (i == 0 || j == 0) dp[i][j] = 1;

                    // Recursive cases: If the current cell is not on the border, then dp[i][j] is the minimum of up, down, and diagonal left 
                    else dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }

                maxLen = Math.max(dp[i][j], maxLen);
            }
        }

        return maxLen * maxLen;
    }
}