class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> used = new HashSet<>();
        backTrackHelper(nums, res, new ArrayList<>(), used);
        return res;
    }

    public void backTrackHelper(int[] nums, List<List<Integer>> res, List<Integer> temp, Set<Integer> used) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used.contains(i)) {
                temp.add(nums[i]);
                used.add(i);

                // recursively call the backtrackHelper
                backTrackHelper(nums, res, temp, used);

                // backtrack step: remove the number added from temp, and from used
                temp.remove(temp.size() - 1);
                used.remove(i);
            }
        }
    }
}