class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        m, n = len(text1), len(text2)

        # Let dp[i][j] represent the longest length until the i-th and j-th character
        dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]

        for i in range(1, m+1): 
            for j in range(1, n+1):
                # if the current character of both text match
                if (text1[i-1] == text2[j-1]):
                    dp[i][j] = 1 + dp[i-1][j-1]
                # if the current character of both texts doesn't match
                # either excluse the character from text1 or text2
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        return dp[-1][-1]