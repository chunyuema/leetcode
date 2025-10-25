class Solution:
    def maximumTotalDamage(self, power: List[int]) -> int:
        power.sort()
        counter = Counter(power)
        memo = [-1 for _ in range(len(power))]
        return self.dpHelper(power, 0, counter, memo)

    # max damage to yield if we start from the currIdx
    def dpHelper(self, power, currIdx, counter, memo):

        # base case
        if currIdx >= len(power): return 0

        # memoized case: 
        if memo[currIdx] != -1: return memo[currIdx]

        # recursive cases
        p = power[currIdx]
        
        # option 1: cast all spells with current power p, move to next available index
        nextIdx = bisect_left(power, p + 3)  # ✅ find next valid index
        cast = p * counter[p]+ self.dpHelper(power, nextIdx, counter, memo)

        # option 2: do not cast the current power p spell, move to currIdx+1
        nextIdx = bisect_left(power, p + 1)  # ✅ find next valid index
        noCast = self.dpHelper(power, nextIdx, counter, memo)

        memo[currIdx] = max(cast, noCast)
        return memo[currIdx]
