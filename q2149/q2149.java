class Solution {
    public int[] rearrangeArray(int[] nums) {
        int positiveIndex = 0;
        int negativeIndex = 1;
        int[] res = new int[nums.length];
        for (int num : nums) {
            if (num > 0) {
                res[positiveIndex] = num;
                positiveIndex += 2;
            } else {
                res[negativeIndex] = num;
                negativeIndex += 2;
            }
        }
        return res;
    }
}