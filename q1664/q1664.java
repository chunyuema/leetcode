class Solution {
    public int waysToMakeFair(int[] nums) {
        int[] prefixOddSum = new int[nums.length];
        int[] prefixEvenSum = new int[nums.length];
        int leftOddSum = 0; 
        int leftEvenSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 != 0) leftOddSum += nums[i];
            else leftEvenSum += nums[i];
            prefixOddSum[i] = leftOddSum; 
            prefixEvenSum[i] = leftEvenSum;
        }

        int res = 0;
        int rightOddSum = 0; 
        int rightEvenSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            leftOddSum = i > 0 ? prefixOddSum[i-1] : 0;
            leftEvenSum = i > 0 ? prefixEvenSum[i-1] : 0;
            if (leftOddSum + rightEvenSum == leftEvenSum + rightOddSum) res++;
            rightOddSum += (i % 2 != 0) ? nums[i] : 0;
            rightEvenSum += (i % 2 == 0) ? nums[i] : 0;
        }

        return res;
    }
}