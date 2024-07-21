class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] memo = new int[n+1][n+1];
        
        // Initialize memoization array to store results
        for (int[] row : memo) Arrays.fill(row, -1);
        
        // Calculate total sum of stones in piles for quick access
        int[] suffixSum = new int[n];
        suffixSum[n-1] = piles[n-1];
        for (int i = n-2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i+1] + piles[i];
        }
        
        return dpHelper(piles, 0, 1, memo, suffixSum);
    }
    
    private int dpHelper(int[] piles, int currIdx, int currM, int[][] memo, int[] suffixSum) {
        // Base case:
        if (currIdx >= piles.length) return 0;
        
        // Memoized case:
        if (memo[currIdx][currM] != -1) return memo[currIdx][currM];
        
        // Recursive case:
        int bestScoreForAlice = 0;
        for (int nextM = 1; nextM <= 2 * currM && currIdx + nextM <= piles.length; nextM++) {
            int nextIdx = currIdx + nextM;
            int maxScore = prefixSum[currIdx] - dpHelper(piles, nextIdx, Math.max(currM, nextM), memo, suffixSum);
            bestScoreForAlice = Math.max(bestScoreForAlice, maxScore);
        }
        
        memo[currIdx][currM] = bestScoreForAlice;
        return bestScoreForAlice;
    }
}
