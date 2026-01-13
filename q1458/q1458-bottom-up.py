class Solution:
    def maxDotProduct(self, nums1, nums2):
        n, m = len(nums1), len(nums2)
        dp = [[float('-inf')] * (m + 1) for _ in range(n + 1)]

        for i in range(n - 1, -1, -1):
            for j in range(m - 1, -1, -1):
                take = nums1[i] * nums2[j]
                
                # opt1 = max(take, take + dp[i + 1][j + 1])
                # opt2 = dp[i+1][j]
                # opt3 = dp[i][i-1]
                # dp[i][j] = max(opt1, opt2, opt3)
                dp[i][j] = max(
                    take,
                    take + dp[i + 1][j + 1],
                    dp[i + 1][j],
                    dp[i][j + 1]
                )

        return dp[0][0]
