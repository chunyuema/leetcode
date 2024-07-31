class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0) return n;
        if (n == 0) return m;
        int[][] memo = new int[m + 1][n + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dpHelper(word1, word2, m - 1, n - 1, memo);
    }

    // Let dpHelper(i, j) represent the min edit distance for word1 and word2 up until index i and index j
    private int dpHelper(final String word1, final String word2, int i, int j, int[][] memo) {
        // Base case: if one of the strings is empty
        if (i < 0) return j + 1; // need to insert all characters of word2
        if (j < 0) return i + 1; // need to delete all characters of word1

        // Memoized case: 
        if (memo[i + 1][j + 1] != -1) return memo[i + 1][j + 1];

        // Recursive case: 
        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i + 1][j + 1] = dpHelper(word1, word2, i - 1, j - 1, memo);
        } else {
            int insert = dpHelper(word1, word2, i, j - 1, memo) + 1;
            int delete = dpHelper(word1, word2, i - 1, j, memo) + 1;
            int replace = dpHelper(word1, word2, i - 1, j - 1, memo) + 1;
            memo[i + 1][j + 1] = Math.min(Math.min(insert, delete), replace);
        }
        return memo[i + 1][j + 1];
    }
}
