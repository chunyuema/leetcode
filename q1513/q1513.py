class Solution:
    def numSub(self, s: str) -> int:
        res = 0
        MOD = 10**9 + 7
        
        # total number of valid substr ending at previous index
        prev = 0
        for c in s:
            # track number of valid substr ending at current index
            curr = 0
            if c == '1':
                # current c can form 1 valid substr with each one of the previous
                # valid substring ending at the previous index
                curr = prev + 1
                res = (res + curr) % MOD
            
            # update the prev value as we have already updated res
            prev = curr

        return res
