class Solution:
    def countNumbersWithUniqueDigits(self, n: int) -> int:
        if n == 0: return 1
        if n == 1: return 10

        dp = [0]*(n+1)
        dp[1] = 10
        dp[2] = 9*9

        for i in range(3, n+1):
            # dp[i-1] used i - 1 unique digits
            # any other 10 - (i - 1) digit can form a unique number
            dp[i] = (10 - i + 1) * dp[i-1]
        
        return sum(dp)
