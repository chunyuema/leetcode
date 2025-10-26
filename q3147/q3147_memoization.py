class Solution:
    def maximumEnergy(self, energy: List[int], k: int) -> int:
        n = len(energy)
        memo = [math.inf * -1] * n

        def dpHelper(i):
            # base case: outside the range
            if i >= n:
                return 0

            # memoized case
            if memo[i] != -math.inf:
                return memo[i]

            # recursive case
            memo[i] = energy[i] + dpHelper(i + k)
            return memo[i]

        return max(dpHelper(i) for i in range(n))
