class Solution {
    public int maxProduct(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > firstMax) {
                secondMax = Math.max(firstMax, secondMax);
                firstMax = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
        }
        return (firstMax - 1) * (secondMax - 1);
    }
}