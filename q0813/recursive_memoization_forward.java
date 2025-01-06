class Solution {

    // Memoization table, memo[i][k] represents the max sum of averages starting from index i with k partitions
    private double[][] memo;
    private double[] prefixSum;

    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;

        // Initialize the memoization table with -1 indicating uncomputed results
        memo = new double[n][k + 1];
        for (double[] row : memo) Arrays.fill(row, -1.0);

        // Calculate prefix sums to make subarray average calculation efficient
        prefixSum = new double[n + 1];
        for (int i = 1; i <= n; i++) prefixSum[i] = prefixSum[i - 1] + nums[i - 1];

        // Start the recursive helper function to compute the maximum sum of averages
        return dpHelper(nums, k, 0);
    }

    // dpHelper(i, k) returns the maximum sum of averages from index i with k partitions left
    private double dpHelper(int[] nums, int k, int i) {
        // Base case: If no partitions are left, we simply return the average of the remaining subarray
        if (k == 1) return getSubArrayAvg(i, nums.length - 1);

        // Check if we've already computed this subproblem
        if (memo[i][k] != -1) return memo[i][k];

        // Recursive case: Try all possible ways to split the array at different points
        double maxAvgSum = Double.MIN_VALUE;
        for (int j = i; j < nums.length - (k - 1); j++) {
            double avg = getSubArrayAvg(i, j); // Average of subarray from i to j
            maxAvgSum = Math.max(maxAvgSum, avg + dpHelper(nums, k - 1, j + 1)); // Try next partition starting at j + 1
        }

        // Memoize the result
        memo[i][k] = maxAvgSum;
        return maxAvgSum;
    }

    // Helper function to get the average of the subarray nums[i...j] using prefix sum
    private double getSubArrayAvg(int i, int j) {
        return (prefixSum[j + 1] - prefixSum[i]) / (double) (j - i + 1);
    }
}

