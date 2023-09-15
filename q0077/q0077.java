class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrackHelper(n, k, 1, res, new ArrayList<>());
        return res;
    }

    private void backtrackHelper(int n, int k, int idx, List<List<Integer>> res, List<Integer> temp) {
        // check for the base case: if the length satisfy the condition, one valid
        // combination has been created => add to solution
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // start looping from the current position:
        for (int i = idx; i <= n; i++) {
            // move ahead: add the num to temp
            temp.add(i);

            // recurse on the backtrack function
            backtrackHelper(n, k, i + 1, res, temp);

            // backtrack: remove the num from temp
            temp.remove(temp.size() - 1);
        }
    }
}