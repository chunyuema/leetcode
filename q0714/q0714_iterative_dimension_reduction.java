class Solution {
    public int maxProfit(int[] prices, int fee) {
        // The cached value:
        // max profit until previous day holding a stock
        int prevHasStock = -1 * prices[0];
        // max profit until previous day without holding a stock
        int prevNoStock = 0;

        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            // Case 1: Has stock on current day
            // == has stock on previous day but did not sell on current day
            // OR has no stock on previous day but buy on current day
            int currHasStock = Math.max(prevHasStock, prevNoStock - prices[i]);

            // Case 2: Has no stock on current day
            // == has no stock on previous day and does not buy on current day
            // OR has stock on previous day but sell on current day
            int currNoStock = Math.max(prevNoStock, prevHasStock + prices[i] - fee);

            // Update the result to track the max profit seen
            res = Math.max(currHasStock, currNoStock);

            // Update the cached value for next iteration
            prevHasStock = currHasStock;
            prevNoStock = currNoStock;
        }

        return res;
    }
}