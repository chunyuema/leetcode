class Solution:
    def climbStairs(self, n: int) -> int:
        memo = [-1] * (n+1)
        return self.dpHelper(n, memo)
    
    def dpHelper(self, n, memo): 
        if n == 0: return 1
        if n == 1: return 1
        if memo[n] != -1: return memo[n]
        res = self.dpHelper(n-1, memo) + self.dpHelper(n-2, memo)
        memo[n] = res
        return res