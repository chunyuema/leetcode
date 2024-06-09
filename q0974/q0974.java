class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        
        // Any number divided by k will have a mod of 0 ... k-1
        int[] remainders = new int[k];
        // Initialize the 0 remainder case to be 1
        remainders[0] = 1;
        
        
        int prefixSum = 0;
        for (int num : nums) {
            // Update the current prefixSum
            prefixSum += num;
            
            // Look for the right remainder to check (correct for negative cases)
            int remainder = ((prefixSum % k) + k) % k;
            
            // Update the result of subarray counts
            res += remainders[remainder];
            
            // Update the remainders count
            remainders[remainder]++;
        }
        return res;
    }
}