class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currNum = nums[i];
            int newCurrMax = currMax * currNum;
            int newCurrMin = currMin * currNum;
            currMax = Math.max(newCurrMax, Math.max(newCurrMin, currNum));
            currMin = Math.min(newCurrMax, Math.min(newCurrMin, currNum));
            res = Math.max(res, currMax);
        }
        return res;
    }
}