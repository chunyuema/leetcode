class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 0; 
        for (int num : nums) right = Math.max(num, right);

        while (left < right) {
            int mid = (left + right) / 2;

            // If we can hit the target balls / bag, try a smaller target
            if (isPossible(nums, maxOperations, mid)) {
                right = mid;
            } 
            
            // If we cannot hit the target balls / bag, try a larger target
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Given nums, and the maxOperations allowed, check if a target is possible
    private boolean isPossible(int[] nums, int maxOperations, int target) {
        int totalOperaions = 0; 
        for (int num : nums) {
            // Compute operations neeeded for a given bag to achieve the target
            int operationsNeeded = (int) Math.ceil(num / (double) target) - 1;
            
            // Update totalOperations needed
            totalOperaions += operationsNeeded;

            // If totalOperations needed exceed maxOperations at any given time
            if (totalOperaions > maxOperations) return false; 
        }
        
        return true;
    }
}