class Solution {
    public int countValidSelections(int[] nums) {
        int total = 0;
        int numsSum = 0;
        for (int num : nums) numsSum += num;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (explore(nums.clone(), i, 1, numsSum)) total++;
                if (explore(nums.clone(), i, -1, numsSum)) total++;
            }
        }
        return total;
    }

    private boolean explore(int[] nums, int currIdx, int direction, int numsSum) {
        while (currIdx >= 0 && currIdx < nums.length) {
            if (nums[currIdx] > 0) {
                nums[currIdx]--;
                numsSum--;
                direction = -1 * direction;
            }
            currIdx = currIdx + direction;
        }
        return numsSum == 0;
    }
}
