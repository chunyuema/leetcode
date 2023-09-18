class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for (int[] r : memo)
            Arrays.fill(r, -1);
        return dpHelper(word1, word2, 0, 0, memo);
    }

    private int dpHelper(String word1, String word2, int i, int j, int[][] memo) {
        int m = word1.length();
        int n = word2.length();

        // base case
        if (i == m)
            return n - j;
        if (j == n)
            return m - i;

        // memoized case
        if (memo[i][j] != -1)
            return memo[i][j];

        int ans;
        if (word1.charAt(i) == word2.charAt(j)) {
            ans = dpHelper(word1, word2, i + 1, j + 1, memo);
        } else {
            int insert = dpHelper(word1, word2, i, j + 1, memo) + 1;
            int delete = dpHelper(word1, word2, i + 1, j, memo) + 1;
            int replace = dpHelper(word1, word2, i + 1, j + 1, memo) + 1;
            ans = Math.min(Math.min(insert, delete), replace);
        }
        memo[i][j] = ans;
        return ans;
    }
}