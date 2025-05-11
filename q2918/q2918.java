class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0; 
        long sum2 = 0; 
        long zero1 = 0; 
        long zero2 = 0;
        for (int num : nums1) {
            sum1 += num;
            zero1 += (num == 0 ? 1 : 0);
        }

        for (int num : nums2) {
            sum2 += num;
            zero2 += (num == 0 ? 1 : 0);
        }

        // If sum1 and sum2 are already equal 
        if (zero1 == 0 && zero2 == 0) return sum1 == sum2 ? sum1 : -1;

        if (zero1 == 0) return sum2 + zero2 <= sum1 ? sum1 : -1;

        if (zero2 == 0) return sum1 + zero1 <= sum2 ? sum2 : -1;

        return Math.max(sum1 + zero1, sum2 + zero2);
    }
}
