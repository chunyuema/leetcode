class Solution:
    def numberOfWays(self, corridor: str) -> int:
        n = len(corridor)
        self.prefix_sum = [0] * n
        prev = 0
        for i in range(n): 
            if corridor[i] == 'S':
                prev += 1
            self.prefix_sum[i] = prev
        
        return self.dp_helper(0, n)
        
    # The total number of ways to divide if you start from index curr
    @lru_cache(None)
    def dp_helper(self, curr, n):
        # Base case: If there are no more than 2 seats, or exactly 2 seats left
        seats_before = self.prefix_sum[curr-1] if curr > 0 else 0
        remaining_seats = self.prefix_sum[n-1] - seats_before
        if remaining_seats < 2: return 0
        if remaining_seats == 2: return 1

        # Recursive case: 
        # All index next such that prefix_sum[next] - seats_before == 2
        # You can put a divider in any one of them
        target = seats_before + 2
        l = bisect_left(self.prefix_sum, target, curr)
        r = bisect_right(self.prefix_sum, target)

        # All divider positions lead to the same future
        res = (r - l) * self.dp_helper(r, n) % (10**9 + 7)
        return res
