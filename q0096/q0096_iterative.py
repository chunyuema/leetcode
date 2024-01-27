class Solution:
    def numTrees(self, n: int) -> int:
        dp = [0 for _ in range(n+1)]
        dp[0] = 1
        dp[1] = 1
        for i in range(2, n+1):
            bstCount = 0
            # loop through all nodes j where j <= i
            for j in range(1, i+1):
                # left bst count = number of nodes less than j
                left = dp[j-1]
                # right best count = number of nodes from j to i
                right = dp[i-j]

                bstCount += left * right
            dp[i] = bstCount
        return dp[n]