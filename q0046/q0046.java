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

        // loop from the beginning because ordering matters for backtracking
        for (int i = 0; i < nums.length; i++) {

            // only consider i if it has not been used before
            if (!used.contains(i)) {

                // move ahead: add the num to temp, and mark it as used
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