class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;

        // Represent the maxProfit ending with buy on day i
        int[] buy = new int[prices.length];
        buy[0] = -1 * prices[0];
        buy[1] = Math.max(buy[0], -1 * prices[1]);

        // Represent the maxProfit ending with sell on day i
        int[] sell = new int[prices.length];
        sell[0] = 0;
        sell[1] = Math.max(0, buy[0] + prices[1]);

        for (int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }

        return Math.max(buy[prices.length-1], sell[prices.length-1]);
    }
}