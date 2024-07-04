class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 0 <= amount <= 10^4: hence at most 10^4 coins needed
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        // Loop through all the amount we are trying to hit
        for (int currAmount = 1; currAmount < amount + 1; currAmount++) {
            // Loop through all the coins for prevAmount + coin = currAmount
            for (int coin : coins) {
                int prevAmount = currAmount - coin;
                if (prevAmount >= 0) {
                    dp[currAmount] = Math.min(dp[currAmount], dp[prevAmount] + 1);
                }
            }
        }
        return dp[amount] == 10001 ? -1 : dp[amount];
    }
}