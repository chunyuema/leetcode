class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;

        // Let dp[i] represent the min height achievable if we start from book i
        int[] dp = new int[n];
        dp[n-1] = books[n-1][1];

        for (int i = n - 2; i >= 0; i--) {
            int widthSum = books[i][0];
            int heightMax = books[i][1];

            // Option 1: The previous book was on a different shelf level
            dp[i] = dp[i+1] + heightMax; 

            // Option 2: For all j (j > i), could we fit books[i - j] on the same level
            for (int j = i+1; j < n; j++) {
                widthSum += books[j][0];
                // Break out if the width sum exceededs the shelf width
                if (widthSum > shelfWidth) break;

                // Update the dp[i] value with the max height from books[i - j]
                heightMax = Math.max(heightMax, books[j][1]);
                dp[i] = Math.min(dp[i], (j < n-1 ? dp[j+1] : 0) + heightMax);
            }
        }
        return dp[0];
    }
}