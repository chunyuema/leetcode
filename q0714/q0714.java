class Solution {
    public int maxProfit(int[] prices, int fee) {
        int res = 0;
        int minPrice = prices[0];
        for (int currPrice : prices) {
            minPrice = Math.min(currPrice, minPrice);
            int profitIfSell = currPrice - minPrice - fee;
            if (profitIfSell > 0) {
                res += profitIfSell;
                minPrice = currPrice - fee;
            }
        }
        return res;
    }
}