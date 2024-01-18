class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int currPrefixSum = 0;

        // Count of the arrays with a particular prefixSum
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            currPrefixSum += nums[i];

            // Case 1: when currPrefixSum happens to be equal to k
            res += (currPrefixSum == k ? 1 : 0);

            // Case 2: Get the count of all arrays with prefix sum = current prefix sum - k
            // Since current prefix sum - (current prefix sum - k) = k,
            // the ends of arrays with prefix sum = current prefix sum - k
            // will form subarray of sum k with current index i
            int prevPrefixSum = currPrefixSum - k;
            int prevPrefixSumCount = prefixSumCount.getOrDefault(prevPrefixSum, 0);
            res += prevPrefixSumCount;

            prefixSumCount.put(currPrefixSum, prefixSumCount.getOrDefault(currPrefixSum, 0) + 1);
        }
        return res;
    }
}