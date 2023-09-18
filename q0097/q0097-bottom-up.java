class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;

        // dp(p1, p2) represents whether we can interleave the s1 and s2 starting from i
        // and j respectively such that they can collectively form s3
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // base case: the last cell in the DP array is initialized as 1, this is because
        // if the pointer on s1 and s2 are already at s1.length and s2.length(), then s3
        // has been successfully constructed with substrings from s1 and s2
        dp[s1.length()][s2.length()] = 1;

        // need to loop backwards
        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {

                // case 1: If current character from s1 matches that of s3, then take the
                // solution from one cell down
                if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j))
                    dp[i][j] |= dp[i + 1][j];

                // case 2: If current character from s2 matches that of s3, then take the
                // solution from one cell left
                if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j))
                    dp[i][j] |= dp[i][j + 1];
            }
        }

        return dp[0][0] == 1;
    }
}