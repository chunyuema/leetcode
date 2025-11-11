class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        # build the counts of 0s and 1s for quick reference later
        self.zero_counts = []
        self.one_counts = []
        for s in strs:
            zero_count = s.count('0')
            one_count = len(s) - zero_count
            self.zero_counts.append(zero_count)
            self.one_counts.append(one_count)
        
        memo = dict()
        return self.dpHelper(0, m, n, memo)

    def dpHelper(self, curr_idx, m, n, memo):
        # base case
        if curr_idx >= len(self.zero_counts): return 0

        # memoized case: 
        if (curr_idx, m, n) in memo: return memo[(curr_idx, m, n)]

        # recursive case: 
        curr_str_zero = self.zero_counts[curr_idx]
        curr_str_one = self.one_counts[curr_idx]

        # option 1: do not take the current str, and skip to next
        res = self.dpHelper(curr_idx + 1, m, n, memo)

        # option 2: take the current str
        if curr_str_zero <= m and curr_str_one <= n:
            res = max(res, 1 + self.dpHelper(curr_idx + 1, m - curr_str_zero, n - curr_str_one, memo))
        
        memo[(curr_idx, m, n)] = res
        return res
