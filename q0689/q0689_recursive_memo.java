class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // Calculate sum of all possible k-length subarrays
        subArraySums = getSubArraySums(nums, k);

        // Memoization table to store results for dp
        memo = new int[nums.length - k + 1][4]; 
        for (int[] row : memo) Arrays.fill(row, -1);

        // Find the max sum by calling dpHelper
        int maxSum = dpHelper(0, k, 3); 

        // Reconstruct the solution leading to the maxSum
        List<Integer> results = new ArrayList<>();
        reconstructMaxSum(k, 0, 3, results); // Reconstruct the indices of the 3 subarrays

        // Convert List to array
        int[] indices = new int[3];
        for (int i = 0; i < 3; i++) indices[i] = results.get(i); 

        return indices;
    }

    private int[][] memo;
    private int[] subArraySums; 

    // Function to calculate the sum of every k-length subarray
    private int[] getSubArraySums(int[] nums, int k) {
        int[] sums = new int[nums.length - k + 1];
        int currSum = 0;
        for (int i = 0; i < k; i++) currSum += nums[i];
        sums[0] = currSum;

        for (int i = k; i < nums.length; i++) {
            currSum = currSum - nums[i - k] + nums[i];
            sums[i - k + 1] = currSum;
        }
        return sums;
    }

    // DP function to compute the max sum with remaining subarrays to pick
    private int dpHelper(int i, int k, int numLeft) {
        // Base case: no subarrays left to pick
        if (numLeft == 0) return 0;
        if (i >= subArraySums.length) return numLeft > 0 ? Integer.MIN_VALUE : 0;

        // Memoization: if already calculated, return the stored value
        if (memo[i][numLeft] != -1) return memo[i][numLeft];

        // Option 1: Take the current subarray and move to i + k, reduce numLeft
        int take = subArraySums[i] + dpHelper(i + k, k, numLeft - 1);

        // Option 2: Skip the current subarray and move to the next index
        int skip = dpHelper(i + 1, k, numLeft);

        // Store the best result for this state
        memo[i][numLeft] = Math.max(take, skip);
        return memo[i][numLeft];
    }

    // Function to reconstruct the indices of the subarrays that lead to maxSum
    private void reconstructMaxSum(int k, int i, int numLeft, List<Integer> results) {
        if (numLeft == 0) return;
        if (i >= subArraySums.length) return;

        // Option 1: Take the current subarray and move to i + k
        int takeMaxSum = subArraySums[i] + dpHelper(i + k, k, numLeft - 1);
        
        // Option 2: Skip the current subarray
        int skipMaxSum = dpHelper(i + 1, k, numLeft);

        // If taking the current subarray gives a better result, include it
        if (takeMaxSum >= skipMaxSum) {
            results.add(i); // Add the index of the current subarray
            reconstructMaxSum(k, i + k, numLeft - 1, results); // Recurse to next subarray
        } else {
            reconstructMaxSum(k, i + 1, numLeft, results); // Skip the current subarray
        }
    }
}

