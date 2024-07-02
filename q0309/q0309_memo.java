class Solution {
    public int maxProfit(int[] prices) {
        Map<String, Integer> memo = new HashMap<>();
        return dpHelper(prices, 0, false, false, memo);
    }
    
    // Let dpHelper(i) represent the max profit you can make if you start trading from day i
    private int dpHelper(int[] prices, int i, boolean isHoldingStock, boolean isCoolingOff, Map<String, Integer> memo) {
        // base case: best you can do is 0 
        if (i == prices.length) return 0;

        // memoized case
        String currState = i + "," + isHoldingStock + "," + isCoolingOff;
        if (memo.containsKey(currState)) return memo.get(currState);

        // recursive cases
        int currPrice = prices[i];
        
        // case 1: buy on current day (if currently not holding stock && not in cool down mode)
        int buy = Integer.MIN_VALUE;
        if (!isHoldingStock && !isCoolingOff) {
            buy = -currPrice + dpHelper(prices, i + 1, true, false, memo);
        }
        
        // case 2: sell on current day (as long as one is holding a stock)
        int sell = Integer.MIN_VALUE;
        if (isHoldingStock) {
            sell = currPrice + dpHelper(prices, i + 1, false, true, memo);
        }
        
        // case 3: chill on current day
        int chill = dpHelper(prices, i + 1, isHoldingStock, false, memo);

        int maxProfit = Math.max(buy, Math.max(sell, chill));
        memo.put(currState, maxProfit);

        return maxProfit;
    }
}