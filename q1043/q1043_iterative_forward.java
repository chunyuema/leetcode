class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // Let dp[i] represent the maxSum until index i
        int[] dp = new int[arr.length];
        dp[0] = arr[0];

        for (int i = 0; i < arr.length; i++) {
            // Initialize the currMax to be the current number
            int currMax = arr[i];

            // Current number could be part of the subarray of at most length of k
            // Hence dp[i] = max(dp[j-1] + currMax * (i-j+1))
            // Note that j >= 0, and dp[j-1] is 0 if j == 0 (prevent out of bound)
            for (int j = i; j > Math.max(-1, i - k); j--) {
                currMax = Math.max(currMax, arr[j]);
                int prevSubarraySum = j >= 1 ? dp[j - 1] : 0;
                dp[i] = Math.max(dp[i], prevSubarraySum + currMax * (i - j + 1));
            }
        }
        return dp[arr.length - 1];
    }
}