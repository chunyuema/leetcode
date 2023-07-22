class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        int[][] directions = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 } };

        double[][] dp = new double[n][n];
        dp[row][column] = 1.0;

        for (int move = 0; move < k; move++) {
            double[][] newDp = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] direction : directions) {
                        int nextI = i + direction[0];
                        int nextJ = j + direction[1];
                        if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < n) {
                            newDp[nextI][nextJ] += dp[i][j] / 8.0;
                        }
                    }
                }
            }

            dp = newDp;
        }

        double prob = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                prob += dp[i][j];
            }
        }
        return prob;
    }
}