class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        n = len(s1)
        m = len(s2)

        # dp[i][j] represents the min ascii delete sum from s1[i] and s2[j]
        dp = [[0] * (m + 1) for _ in range(n+1)]

        # fill the base cases
        for i in range(n-1, -1, -1):
            dp[i][m] = dp[i+1][m] + ord(s1[i])
        for j in range(m-1, -1, -1):
            dp[n][j] = dp[n][j+1] + ord(s2[j])

        # fill the dp table
        for i in range(n-1, -1, -1):
            for j in range(m-1, -1, -1):
                if s1[i] == s2[j]: 
                    dp[i][j] = dp[i+1][j+1]
                else:
                    dp[i][j] = min(ord(s1[i]) + dp[i+1][j],
                                   ord(s2[j]) + dp[i][j+1])
        return dp[0][0]
