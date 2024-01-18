class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        return self.dpHelper(prices, 0, False, False, dict())
    
    def dpHelper(self, prices, i, isHoldingStock, isCoolingOff, memo):
        # base case: best you can do is 0 
        if i == len(prices): return 0

        # memoized case
        currState = (i, isHoldingStock, isCoolingOff)
        if currState in memo: return memo[currState]

        # recursive cases
        currPrice = prices[i]
        # case 1: buy on current day (if currently not holding stock && not in cool down mode)
        buy = float("-inf")
        if not isHoldingStock and not isCoolingOff: 
            buy = -1 * currPrice + self.dpHelper(prices, i+1, True, False, memo)
        
        # case 2: sell on current day (as long as one is holding a stock)
        sell = float("-inf")
        if isHoldingStock:
            sell = currPrice + self.dpHelper(prices, i+1, False, True, memo)
        
        # case 3: chill on current day
        chill = self.dpHelper(prices, i+1, isHoldingStock, False, memo)

        memo[currState] = max(buy, sell, chill)

        return memo[currState]