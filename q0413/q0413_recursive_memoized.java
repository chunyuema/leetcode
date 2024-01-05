class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>();

        // The # of slices is the sum of arithmetic slices ending at i, for all i in the
        // range of nums.
        int totalSlice = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSlice += dpHelper(nums, i, memo);
        }
        return totalSlice;
    }

    // dpHelper gives the total number of arithmetic slices ending at i
    private int dpHelper(int[] nums, int i, Map<Integer, Integer> memo) {

        // base case: the length of the slice is not long enought => return 0
        if (i == 0 || i == 1)
            return 0;

        // memoized case: if we have previous computed dpHelper(i)
        if (memo.containsKey(i))
            return memo.get(i);

        // by default set the slice to 0
        int res = 0;

        // if the number can be added:
        if (nums[i - 1] - nums[i - 2] == nums[i] - nums[i - 1]) {
            // recursively compute the # of arithmetic slices ending at i-1
            res = 1 + dpHelper(nums, i - 1, memo);
        }

        // record the solution in the memo for other recursive cases to use
        memo.put(i, res);
        return res;
    }
};