class Solution {
    public int maxProductDifference(int[] nums) {
        int largest = 0;
        int secondLargest = 0;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else {
                secondLargest = Math.max(secondLargest, num);
            }

            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else {
                secondSmallest = Math.min(secondSmallest, num);
            }
        }

        return largest * secondLargest - smallest * secondSmallest;
    }
}