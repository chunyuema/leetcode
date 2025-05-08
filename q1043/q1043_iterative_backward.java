class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // Let dp[i] represent the maxSum if we start at i
        int[] dp = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            // Initialize the currMax to be the current number
            int currMax = arr[i];

            // We could include upto k next elements in the subarray
            // Hence dp[i] = max of (dp[j+1] + currMax * (j-i+1))
            // Note that j < arr.length, and dp[j+1] is 0 if j+1 > arr.length (prevent out
            // of bound)
            for (int j = i; j < Math.min(arr.length, i + k); j++) {
                currMax = Math.max(currMax, arr[j]);
                int subarraySum = currMax * (j - i + 1);
                dp[i] = Math.max(dp[i], subarraySum + (j + 1 < arr.length ? dp[j + 1] : 0));
            }
        }
        return dp[0];
    }
}