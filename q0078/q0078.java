class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrackHelper(res, nums, 0, new ArrayList<>());
        return res;
    }

    public void backtrackHelper(List<List<Integer>> res, int[] nums, int start, List<Integer> currTmp) {
        res.add(new ArrayList<>(currTmp));
        for (int i = start; i < nums.length; i++) {
            currTmp.add(nums[i]);
            backtrackHelper(res, nums, i + 1, currTmp);
            currTmp.remove(currTmp.size() - 1);
        }
    }
}