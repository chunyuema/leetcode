class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumIndexMap = new HashMap<>();
        prefixSumIndexMap.put(0, -1);

        int currPrefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currPrefixSum += nums[i];
            int modK = currPrefixSum % k; 
            System.out.println(modK);
            if (prefixSumIndexMap.containsKey(modK)){
                if (i - prefixSumIndexMap.get(modK) >= 2) return true;
            } 
            else prefixSumIndexMap.put(modK, i); 
        }
        return false;
    }
}