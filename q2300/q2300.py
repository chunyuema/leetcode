class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        res = []
        potions.sort()
        n = len(potions)
        for s in spells: 
            if s == 0:
                res.append(0)
                continue
            minPotion = math.ceil(success / s)
            idx = bisect.bisect_left(potions, minPotion)
            res.append(n - idx)
        return res
