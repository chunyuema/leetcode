class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrackHelper(res, nums, new ArrayList<>(), 0);
        return res;
    }

    private void backtrackHelper(List<List<Integer>> res, int[] nums, List<Integer> temp, int idx) {
        res.add(new ArrayList<>(temp));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            backtrackHelper(res, nums, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}