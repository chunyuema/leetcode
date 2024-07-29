class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;

        // Let dp[i] represent the min height achievable until book i
        int[] dp = new int[n];
        dp[0] = books[0][1];

        for (int i = 1; i < n; i++) {
            int widthSum = books[i][0];
            int heightMax = books[i][1];

            // Option 1: New shelf with the current book
            dp[i] = dp[i-1] + books[i][1]; 

            // Option 2: For all j (j < i), could we fit books[j - i] on the same level
            for (int j = i-1; j >= 0; j--) {
                widthSum += books[j][0];
                // Break out if the width sum exceededs the shelf width
                if (widthSum > shelfWidth) break; 
                heightMax = Math.max(heightMax, books[j][1]);
                dp[i] = Math.min(dp[i], (j == 0 ? 0 : dp[j-1]) + heightMax);
            }
        }
        return dp[n-1];
    }
}
