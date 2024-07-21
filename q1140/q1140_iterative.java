class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n + 1][n + 1];

        // Calculate suffix sums
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        // Bottom-up DP
        for (int currIdx = n - 1; currIdx >= 0; currIdx--) {
            for (int currM = 1; currM <= n; currM++) {
                if (currIdx + 2 * currM >= n) {
                    dp[currIdx][currM] = suffixSum[currIdx];
                } else {
                    int bestScoreForAlice = 0;
                    for (int nextM = 1; nextM <= 2 * currM; nextM++) {
                        int nextIdx = currIdx + nextM;
                        int maxScore = suffixSum[currIdx] - dp[nextIdx][Math.max(currM, nextM)];
                        bestScoreForAlice = Math.max(bestScoreForAlice, maxScore);
                    }
                    dp[currIdx][currM] = bestScoreForAlice;
                }
            }
        }

        return dp[0][1];
    }
}
