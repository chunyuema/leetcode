class Solution:
    def minimumOneBitOperations(self, n: int) -> int:
        memo = dict()
        return self.dpHelper(n, memo)

    # dpHelper is the cost of reducing n to 0 
    def dpHelper(self, n, memo):
        # Base case: n = 0
        if n == 0: return 0

        # Memoized case: if n has been computed
        if n in memo: return memo[n]

        # Recursive cases
        # Find the highest set bit msb in the num, 
        # Cost of converting 0001(k-th bit) 1111.111 into 0, the full cost is 2^(msb + 1) - 1
        msb = int(log2(n))
        fullCost = 2 ** (msb + 1) - 1

        # However, the above assumes worst case of all 1's after k-th bit 
        # In reality, you can avoid the the cost 
        avoidedCost = self.dpHelper(n - (1 << msb), memo)

        memo[n] = fullCost - avoidedCost
        return memo[n] 
