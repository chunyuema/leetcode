class Solution {
    public int maxProfit(int[] prices) {
        // Edge case
        if (prices == null || prices.length == 0) {
            return 0;
        }

        Map<String, Integer> memo = new HashMap<>();
        return dpHelper(prices, 0, false, memo);
    }
    
    private int dpHelper(int[] prices, int i, boolean holdingStock, Map<String, Integer> memo) {
        // Base case
        if (i >= prices.length) {
            return 0;
        }

        // Memoization key
        String key = i + "_" + holdingStock;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Recursive cases
        // Option 1: Do nothing
        int chill = dpHelper(prices, i + 1, holdingStock, memo);
        
        // Option 2: Buy stock
        int buy = -prices[i] + dpHelper(prices, i + 1, true, memo);
        
        // Option 3: Sell stock
        int sell = 0;
        if (holdingStock) {
            sell = prices[i] + dpHelper(prices, i + 2, false, memo); // cooling-off period after selling
        }

        // Maximize profit
        int maxProfit = Math.max(chill, Math.max(buy, sell));
        memo.put(key, maxProfit);

        return maxProfit;
    }
}
