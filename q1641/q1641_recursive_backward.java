class Solution {
    public int countVowelStrings(int n) {
        // Create a memoization table with all elements initialized to -1
        int[][] memo = new int[n + 1][5];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dpHelper(n, 4, memo);
    }

    // Let dpHelper(i, j) represent # of strings with lexicographically sorted vowel ending <= j-th vowel
    private int dpHelper(int i, int j, int[][] memo) {
        // Base case: if the length is 0, there's exactly one way (the empty string)
        if (i == 0) return 1;

        // Memoized case: return the result if it has been computed before
        if (memo[i][j] != -1) return memo[i][j];

        // Recursive case: Calculate the number of sorted vowel strings of length i
        int result = 0;
        // Loop over all possible vowel characters <= j-th vowel
        for (int k = 0; k <= j; k++) {
            // It is safe to append the k-th vowel to any of the strings from dpHelper(i-1, k)
            // This makes those strings reach length i, without breaking the lexicographical order
            result += dpHelper(i - 1, k, memo);
        }

        memo[i][j] = result;
        return result;
    }
}
