class Solution {
    public int[] resultsArray(int[] nums, int k) {

        int[] powerArray = new int[nums.length - k + 1];
        Arrays.fill(powerArray, -1);

        int currLen = 1;
        for (int i = 1; i < k; i++) {
            if (nums[i] == nums[i-1]+1) currLen++;
            else currLen = 1;
        }
        if (currLen == k) powerArray[0] = nums[k-1];

        for (int l = 1, r = k; r < nums.length; l++, r++) {
            if (nums[r] == nums[r - 1] + 1) currLen++;
            else currLen = 1;
            if (currLen >= k) powerArray[l] = nums[r];
        }
        return powerArray;
    }
}