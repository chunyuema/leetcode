class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] memo = new int[arr.length];
        Arrays.fill(memo, -1);
        return dpHelper(arr, k, 0, memo);
    }

    // let dpHelper return the max after partitioning if we start from index start
    private int dpHelper(int[] arr, int k, int start, int[] memo) {
        // base case: return 0 if start goes out of the boundary
        if (start >= arr.length)
            return 0;

        // memoized case: if we have already computed this solution
        if (memo[start] != -1)
            return memo[start];

        // recursive case: initialize the current subarray max as arr[start]
        int currMax = arr[start];
        for (int end = start; end < Math.min(arr.length, start + k); end++) {
            // Update the current subarray max
            currMax = Math.max(currMax, arr[end]);

            // compute the current subarry sum
            int subarraySum = (end - start + 1) * currMax;

            // recursively compute the result if start from index end+1
            memo[start] = Math.max(memo[start], subarraySum + dpHelper(arr, k, end + 1, memo));
        }

        return memo[start];
    }
}