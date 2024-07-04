// This solution has TLE problem
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        // 0 <= amount <= 10^4: hence at most 10^4 coins needed
        Arrays.fill(memo, -1);
        memo[0] = 0;
        
        return dpHelper(coins, amount, memo);
    }


    private int dpHelper(final int[] coins, int targetAmount, int[] memo) {
        if (memo[targetAmount] != -1) return memo[targetAmount];

        int targetCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int prevAmount = targetAmount - coin;
            
            if (prevAmount >= 0) {
                int prevCoins = dpHelper(coins, prevAmount, memo);
                if (prevCoins != -1) targetCoins = Math.min(prevCoins + 1, targetCoins);
            }
        }

        memo[targetAmount] = targetCoins == Integer.MAX_VALUE ? -1 : targetCoins;

        return memo[targetAmount];
    }
}