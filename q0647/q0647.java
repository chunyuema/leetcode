class Solution {
    public int countSubstrings(String s) {
        int[][] dp = new int[s.length()][s.length()];

        // Each character on its own is a valid palindromic substring
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            res++;
        }

        // Loop from smallest possible length 1 to the largest possible length
        for (int l = 1; l < s.length(); l++) {
            // Use that length to determine the start and end indices to check
            for (int i = 0; i < s.length() - l; i++) {
                int j = i + l;
                // If the character at start and end indices match
                // Check if (i, j) is a valid palindromic substring
                if (s.charAt(i) == s.charAt(j)) {
                    // If the length is 1 (i == j) or (i+1, j-1) is a palindromic substring
                    // Then a new palindromic substring can be formed, increment the result
                    if (l == 1 || (l != 1 && dp[i + 1][j - 1] == 1)) {
                        dp[i][j] = 1;
                        res++;
                    }
                }
            }
        }

        return res;
    }
}