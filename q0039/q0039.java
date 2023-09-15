class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrackHelper(candidates, res, temp, target, 0);
        return res;
    }

    private void backtrackHelper(int[] candidates, List<List<Integer>> res, List<Integer> temp, int currDiff, int i) {
        // base case: invalid
        if (currDiff < 0)
            return;

        // base case: if we get the target
        if (currDiff == 0) {
            res.add(new ArrayList(temp));
            return;
        }

        // start looping from index i since the ordering in combination does not matter
        for (int j = i; j < candidates.length; j++) {
            // move ahead: take the candidate, and add it to the temp
            int newDiff = currDiff - candidates[j];
            temp.add(candidates[j]);

            // recursively call from the same i because one number can be used unlimited
            // amount of times
            backtrackHelper(candidates, res, temp, newDiff, j);

            // backtrack: remove the number from the temp
            temp.remove(temp.size() - 1);
        }
    }
}