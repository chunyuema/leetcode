class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] memo = new int[prices.length][2];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return dpHelper(prices, fee, 0, 0, memo);
    }

    // Given a day i and the hasStock status of a person, dpHelper does this:
    // Recursively find out the max profit that is returned if user starts trading
    private int dpHelper(int[] prices, int fee, int i, int hasStock, int[][] memo) {

        // Base Case: If there is no more stock, the max profit is 0
        if (i == prices.length)
            return 0;

        // Memoized step: If dp(i, hasStock) has been computed, return result
        if (memo[i][hasStock] != -1)
            return memo[i][hasStock];

        // Recursive Step:
        // If customer does not have a stock, the only way to change is to buy a stock
        // If customer cannot buy, set this result to 0 to ensure that it is ignored
        int buy = hasStock == 1 ? 0 : dpHelper(prices, fee, i + 1, 1, memo) - prices[i];

        // If customer does have a stock, the only way to change is to sell the stock
        // If customer cannot sell, set this result to 0 to ensure that it is ignored
        int sell = hasStock == 1 ? dpHelper(prices, fee, i + 1, 0, memo) + prices[i] - fee : 0;

        // Otherwise, the customer could choose to ignore today and maintain status quo
        int hold = dpHelper(prices, fee, i + 1, hasStock, memo);

        // Update the memo and return the answer
        memo[i][hasStock] = Math.max(Math.max(buy, sell), hold);
        return memo[i][hasStock];
    }
}