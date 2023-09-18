class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int[] r : dp)
            Arrays.fill(r, Integer.MAX_VALUE);

        // initialize the base cases
        for (int i = 0; i < m + 1; i++)
            dp[i][n] = m - i;
        for (int j = 0; j < n + 1; j++)
            dp[m][j] = n - j;

        // starting from the bottom
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // if two characters match, move to the next one for both i and j
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                    // if two char don't match, choose the min among the three options
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                }
            }
        }

        return dp[0][0];
    }
}