class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return dpHelper(text1, text2, 0, 0, memo);
    }

    // Let dpHelper(i, j) represent the longest common subsequence starting from
    // index i, j for text1, text2
    private int dpHelper(String text1, String text2, int i, int j, int[][] memo) {
        // base case: if either one of the text strings are exhausted
        if (i == text1.length() || j == text2.length())
            return 0;

        // memoized case: if previously seen dpHelper(i, j)
        if (memo[i][j] != -1)
            return memo[i][j];

        // If there is a match:
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + dpHelper(text1, text2, i + 1, j + 1, memo);
        }
        // If there is not a match, move onto the next character for either text1 or
        // text2
        else {
            memo[i][j] = Math.max(dpHelper(text1, text2, i + 1, j, memo),
                    dpHelper(text1, text2, i, j + 1, memo));
        }

        return memo[i][j];
    }
}