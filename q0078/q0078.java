class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrackHelper(res, nums, 0, new ArrayList<>());
        return res;
    }

    public void backtrackHelper(List<List<Integer>> res, int[] nums, int start, List<Integer> currTmp) {
        // since we are generating subsets only, there is not need to check for any
        // condition => simply add it to the final solution
        res.add(new ArrayList<>(currTmp));

        // loop from the start (ordering does not matter, so do not need to repeat
        // previous ones before index start)
        for (int i = start; i < nums.length; i++) {

            // move ahead
            currTmp.add(nums[i]);

            // recursive call
            backtrackHelper(res, nums, i + 1, currTmp);

            // backtrack
            currTmp.remove(currTmp.size() - 1);
        }
    }
}