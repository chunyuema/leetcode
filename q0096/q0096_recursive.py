class Solution:
    def numTrees(self, n: int) -> int:
        memo = [-1 for _ in range(n+1)]
        return self.dpHelper(n, memo)

    # let dpHelper(n) return the number of bst using n nodes
    def dpHelper(self, n, memo):
        # base case: if there is no ndoe / only one node => 1 bst
        if n == 0 or n == 1: return 1

        # memoized case
        if memo[n] != -1: return memo[n]

        bstCount = 0
        # loop through all the nodes available, use it as a root
        for i in range(1, n+1):
            # left bst count = number of nodes smaller than i = i-1
            left = self.dpHelper(i-1, memo)
            # right bst count = number of nodes larger than i = n-i
            right = self.dpHelper(n-i, memo)
            # update the memo to track
            bstCount += (left * right)
        
        memo[n] = bstCount
        return bstCount