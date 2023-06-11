package q0121;

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int res = 0;
        for (int p : prices) {
            minPrice = Math.min(minPrice, p);
            res = Math.max(res, p - minPrice);
        }
        return res;
    }
}
