class Solution:
    def kInversePairs(self, n: int, k: int) -> int:
        mod = 10**9 + 7

        # Let dp[i, j] represent the number of ways to have j inverse pairs given i numbers
        dp =[[0 for _ in range(k + 1)] for _ in range(n+1)]

        # Initialize base cases: the numbers must be in order if there is 0 inverse pairs
        for i in range(n+1):
            dp[i][0] = 1

        for i in range(1, n+1): 
            for j in range(1, k+1): 
                # dp[i][j]   = dp[i-1][j] + dp[i-1][j-1] + ... + dp[i-1][j-(i-1)]
                # dp[i][j-1] = dp[i-1][j-1] + ... + dp[i-1][j-(i-1)] + dp[i-1][j-i]
                # hence dp[i][j] - dp[i][j-1] = dp[i-1][j] - dp[i-1][j-i]
                # hence dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-i]
                tmp = dp[i-1][j-i] if j >= i else 0 
                dp[i][j] = (dp[i][j-1] + dp[i-1][j] - tmp) % mod

        return dp[-1][-1]