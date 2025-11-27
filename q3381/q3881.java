class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        Map<Integer, Long> prefixMin = new HashMap<>();
        prefixMin.put(0, 0L);

        Long prefixSum = 0L; 
        Long maxSum = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            Integer group = (i + 1) % k;
            if (prefixMin.containsKey(group)) {
                Long prevMinPrefixSum = prefixMin.get(group);
                Long subarraySum = prefixSum - prevMinPrefixSum;
                maxSum = Math.max(subarraySum, maxSum);
                prefixMin.put(group, Math.min(prevMinPrefixSum, prefixSum));
            } else {
                prefixMin.put(group, prefixSum);
            }
        }
        return maxSum;
    }
}
