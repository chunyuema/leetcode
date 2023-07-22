class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        int currPrefixSum = 0;
        int res = 0;
        for (int num : nums) {
            currPrefixSum += num;
            // case 1 if currPrefixSum happens to be divisible by k
            res += ((currPrefixSum % k + k) % k == 0 ? 1 : 0);

            // case 2 look for all the previous subarrays with prefixSum = currPrefixSum % k
            int prevPrefixSum = (currPrefixSum % k + k) % k;
            int prevPrefixCount = prefixSumCount.getOrDefault(prevPrefixSum, 0);
            res += prevPrefixCount;

            prefixSumCount.put(prevPrefixSum, prefixSumCount.getOrDefault(prevPrefixSum, 0) + 1);
        }
        return res;
    }
}