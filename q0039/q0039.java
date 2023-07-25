class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrackHelper(candidates, res, temp, target, 0);
        return res;
    }

    private void backtrackHelper(int[] candidates,
            List<List<Integer>> res,
            List<Integer> temp,
            int currDiff,
            int i) {
        if (currDiff == 0) {
            res.add(new ArrayList(temp));
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            int newDiff = currDiff - candidates[j];
            if (newDiff >= 0) {
                temp.add(candidates[j]);
                backtrackHelper(candidates, res, temp, newDiff, j);
                temp.remove(temp.size() - 1);
            }
        }
    }
}