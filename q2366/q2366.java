class Solution {
    public long minimumReplacement(int[] nums) {
        long res = 0;
        int n = nums.length;

        for (int i = n-2; i >= 0; i--) {
            int currNum = nums[i];
            int prevNum = nums[i+1];
            // need to break the currNum if it is large than prevNum (already sorted)
            if (currNum <= prevNum) continue;

            // we need determine how to break the currNum into smaller chunks
            // if [... 9, 3, ...] and 3 is fixed, 9 is broken into [3, 3, 3] (9/3 = 3) numbers
            // if [... 7, 3, ...] and 3 is fixed, 7 is broken into [2, 2, 3] (7/3+1 = 3) numbers
            long breakNum = (long) currNum / prevNum;
            if (currNum % prevNum != 0) breakNum++;

            // add the number of splits into res (to break into breakNum, we needd breakNum -1 splits)
            res += breakNum - 1;

            // update the nums[i] so that later iterations can reference this
            nums[i] = currNum / (int) breakNum;
        }
        return res;
    }
}