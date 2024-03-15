class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length; 

        int[] prefixProducts = new int[n];
        prefixProducts[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixProducts[i] = prefixProducts[i-1] * nums[i];
        }

        int[] suffixProducts = new int[n];
        suffixProducts[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            suffixProducts[i] = suffixProducts[i+1] * nums[i];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int prefix = i > 0 ? prefixProducts[i-1] : 1; 
            int suffix = i < n-1 ? suffixProducts[i+1] : 1; 
            res[i] = prefix * suffix;
        }
        return res;
    }
}