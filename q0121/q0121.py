class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        minPrice = prices[0]
        res = 0
        for p in prices:
            minPrice = min(minPrice, p)
            res = max(res, p - minPrice)
        return res
