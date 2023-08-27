class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Integer> locs = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            locs.put(stones[i], i);
        }
        
        int[][] dp = new int[stones.length + 1][stones.length + 1];
        for (int[] r : dp) Arrays.fill(r, -1);

        dp[0][0] = 1;
        for (int i = 0; i < stones.length; i++) {
            for (int k = 0; k <= stones.length; k++) {
                // If dp[i][k] can be reached, then there are 3 possible ways to jump from i
                // If any of the new locations has a piece of stone, mark that location as 1 the stone is reachable
                if (dp[i][k] == 1) {
                    int jumpK = stones[i] + k; 
                    if (locs.containsKey(jumpK)) dp[locs.get(jumpK)][k] = 1;

                    int jumpKPlusOne = stones[i] + k + 1;
                    if (locs.containsKey(jumpKPlusOne)) dp[locs.get(jumpKPlusOne)][k+1] = 1;

                    int jumpKMinusOne = stones[i] + k - 1;
                    if (locs.containsKey(jumpKMinusOne)) dp[locs.get(jumpKMinusOne)][k-1] = 1;
                }
            }
        }

        // If any of the dp[stones.length-1] is marked as 1, then we can reach it.
        for (int i = 0; i <= stones.length; i++) {
            if (dp[stones.length-1][i] == 1) return true;
        }
        return false;
    }
}