package q0137;

class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        for (int num : nums) {
            // Register the bits appeared in the new number
            // Clear the the bits that have appeared two times
            ones = (num ^ ones) & (~twos);

            // Register the bits appeared in the new number
            // Clear the bits that have only appeared once so far
            twos = (~ones) & (num ^ twos);
        }
        return ones;
    }
}