class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dpHelper(word1, word2, 0, 0, memo);
    }

    // Let dpHelper(i, j) represent the min edit distance if you start editing from index i and index j
    private int dpHelper(final String word1, final String word2, int i, int j, int[][] memo) {
        int m = word1.length();
        int n = word2.length();

        // Base case: 
        if (i == m) return n - j;
        if (j == n) return m - i;

        // Memoized case: 
        if (memo[i][j] != -1) return memo[i][j];


        // Recursive case: 
        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = dpHelper(word1, word2, i+1, j+1, memo);
        } else {
            int insert = dpHelper(word1, word2, i, j + 1, memo) + 1;
            int delete = dpHelper(word1, word2, i + 1, j, memo) + 1;
            int replace = dpHelper(word1, word2, i + 1, j + 1, memo) + 1;
            memo[i][j] = Math.min(Math.min(insert, delete), replace);
        }
        return memo[i][j];
    }
}