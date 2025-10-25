class Solution:
    def maximumTotalDamage(self, power: List[int]) -> int:
        power.sort()
        counter = Counter(power)

        @lru_cache(None)
        def dpHelper(currIdx):
            if currIdx >= len(power): return 0

            # Option 1: Cast this spell
            p = power[currIdx]
            nextIdx = bisect_left(power, p + 3)  # ✅ find next valid index
            cast = p * counter[p]+ dpHelper(nextIdx)

            # Option 2: Do not cast this spell
            nextIdx = bisect_left(power, p + 1) 
            noCast = dpHelper(nextIdx)
            return max(cast, noCast)

        return dpHelper(0)
