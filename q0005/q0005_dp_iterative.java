class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        int l = 0;
        int r = 0;

        // dp(j, i) represents if substring(j, i) is a valid palindromic substring
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            // one character itself is a substring
            dp[i][i] = 1;

            // loop through all indices before i, and look for palindromes
            for (int j = 0; j < i; j++) {
                // if s[i] == s[j], and substring(j+1, i-1) is a substring as well
                // we found a new palindrome, and hence should potentiall update maxLen
                if (s.charAt(i) == s.charAt(j) && ((i - j <= 2 || dp[j + 1][i - 1] == 1))) {
                    dp[j][i] = 1;
                    int currLen = i - j + 1;
                    if (currLen > maxLen) {
                        maxLen = currLen;
                        l = j;
                        r = i;
                    }
                }
            }
        }
        return s.substring(l, r + 1);
    }
}