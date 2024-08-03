class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][5];

        // Base case: if the length is 0, there's exactly one way (the empty string)
        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 4; j++) {
                int result = 0;
                // Loop over all possible vowel characters <= j-th vowel
                for (int k = 0; k <= j; k++) {
                    // It is safe to append the k-th vowel to any of the strings from dpHelper(i-1, k)
                    // This makes those strings reach length i, without breaking the lexicographical order
                    result += dp[i-1][k];
                }
                dp[i][j] = result;
            }
        }

        return dp[n][4];
    }
}