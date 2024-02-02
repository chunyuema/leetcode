class Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s) <= 1: return s
        maxLen = 1
        l, r = 0, 0

        # dp(j, i) represents if substring(j, i) is a valid palindromic substring
        dp = [[0 for _ in range(len(s))] for _ in range(len(s))]

        for i in range(len(s)):
            # one character itself is a substring
            dp[i][i] = 1

            # loop through all indices before i, and look for palindromes
            for j in range(i):

                # if s[i] == s[j], and substring(j+1, i-1) is a substring as well
                # we found a new palindrome, and hence should potentiall update maxLen
                if (s[i] == s[j] and ((i - j <= 2 or dp[j+1][i-1] == 1))):
                    dp[j][i] = 1
                    currLen = i - j + 1
                    if currLen > maxLen: 
                        maxLen = currLen
                        l = j
                        r = i
        return s[l : r+1]