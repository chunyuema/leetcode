class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        self.memo = [[None] * len(s2) for _ in range(len(s1))]
        return self.dp_helper(s1, s2, 0, 0)
    
    # dp_helper represent the min ascii delete sum starting from s1[i] and s2[j]
    def dp_helper(self, s1, s2, i, j):
        # can be optimized with a suffix sum
        if i >= len(s1): return sum(ord(c) for c in s2[j:])
        if j >= len(s2): return sum(ord(c) for c in s1[i:])
        
        # memoized case
        if self.memo[i][j] != None: return self.memo[i][j]
        
        # recursive case
        if s1[i] == s2[j]:
            self.memo[i][j] = self.dp_helper(s1, s2, i+1, j+1)
        else:
            self.memo[i][j] = min(ord(s1[i]) + self.dp_helper(s1, s2, i+1, j),
                                  ord(s2[j]) + self.dp_helper(s1, s2, i, j+1))
        return self.memo[i][j]
