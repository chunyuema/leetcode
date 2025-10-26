class Solution: 
    def maximumEnergy(self, energy: List[int], k: int) -> int:
        # dp[i] represents the max energy yielded if you start from currIdx
        dp = energy[:]

        for currIdx in range(len(energy) - 1, -1, -1):
            nextIdx = currIdx + k 
            # base case: next idx goes out of the range
            if nextIdx >= len(energy): continue

            dp[currIdx] += dp[nextIdx]
        
        return max(dp)
