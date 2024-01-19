class Solution {
    public int minFallingPathSum(int[][] matrix) {

        // Let dp[i, j] represents the min path sum until position (i, j)
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++)
            dp[0][j] = matrix[0][j];

        // To arrive at position (i, j), there are three different ways
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // Either from directly up, or up left, or up right excluding the invalid
                // positions), use placeholder value Integer.MAX_VALUE to remove this
                // possibility during the Math.min step
                int up = dp[i - 1][j];
                int upLeft = j > 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int upRight = j < matrix[0].length - 1 ? dp[i - 1][j + 1] : Integer.MAX_VALUE;
                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(upLeft, upRight));
            }
        }

        // Final result is the max value of the last row of the dp
        int pathSum = Integer.MAX_VALUE;
        for (int j = 0; j < matrix[0].length; j++) {
            pathSum = Math.min(pathSum, dp[matrix.length - 1][j]);
        }
        return pathSum;
    }
}