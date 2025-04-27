class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        HashMap<Integer, Integer> cntMap = new HashMap<>();
        cntMap.put(0, 1);

        // Total number of elements until curr number
        int prefix = 0; 

        // Total number of subarrays
        long res = 0; 

        for (int num : nums) {
            if (num % modulo == k) prefix++;
            // Special count cnt = # of i in the range [l, r] such that nums[i] % modulo == k
            // To find all subarrays ending in num such that their cnt % modulo == k
            // Find all previous subarrays where their cnt % modulo == k
            int target = (prefix - k + modulo) % modulo;
            res += cntMap.getOrDefault(target, 0);

            // Update the cntMap with the current prefix
            cntMap.put(prefix % modulo, 
                    cntMap.getOrDefault(prefix % modulo, 0) + 1);
        }
        return res; 
    }
}
