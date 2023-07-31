class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrackHelper(n, k, 1, res, new ArrayList<>());
        return res;
    }

    private void backtrackHelper(int n, int k, int idx, List<List<Integer>> res, List<Integer> temp) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i <= n; i++) {
            temp.add(i);
            backtrackHelper(n, k, i + 1, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}