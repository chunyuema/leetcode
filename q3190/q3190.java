class Solution {
    public int minimumOperations(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += (num % 3 == 0) ? 0 : 1; 
        }
        return total;
    }
}
