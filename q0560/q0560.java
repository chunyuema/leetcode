class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int currPrefixSum = 0;
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            currPrefixSum += nums[i];
            // case 1: when currPrefixSum happens to be equal to k
            res += (currPrefixSum == k ? 1 : 0);

            // case 2: look for the number of prevPrefixSum = currPrefixSum - k
            int prevPrefixSum = currPrefixSum - k;
            int prevPrefixSumCount = prefixSumCount.getOrDefault(prevPrefixSum, 0);
            res += prevPrefixSumCount;

            prefixSumCount.put(currPrefixSum, prefixSumCount.getOrDefault(currPrefixSum, 0) + 1);
        }
        return res;
    }
}