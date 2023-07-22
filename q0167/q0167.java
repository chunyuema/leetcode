class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int currSum = numbers[l] + numbers[r];
            if (currSum < target) {
                l++;
            } else if (currSum > target) {
                r--;
            } else {
                return new int[] { l + 1, r + 1 };
            }
        }
        return new int[] { -1, -1 };
    }
}