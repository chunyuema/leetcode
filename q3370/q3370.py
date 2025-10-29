class Solution:
    def smallestNumber(self, n: int) -> int:
        res = 0
        # this represents the corresponding number 
        # if the i-th bit is set
        curr = 1
        while res < n:
            res += curr
            curr *= 2
        return res

