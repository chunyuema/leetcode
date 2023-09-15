class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.computeIfAbsent(num, k -> 0);
            counter.put(num, counter.get(num) + 1);
        }

        List<List<Integer>> res = new ArrayList<>();
        backtrackHelper(nums, new ArrayList<>(), res, counter);
        return res;
    }

    private void backtrackHelper(int[] nums, List<Integer> temp, List<List<Integer>> res,
            Map<Integer, Integer> counter) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // loop the entry counter from top to bottom since ordering matters for
        // permutation
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            // only consider to perform the back track if we still have num left to use
            if (count != 0) {
                // move ahead: add num to temp, and subtract 1 from count
                temp.add(num);
                counter.put(num, count - 1);

                // recursively call the function
                backtrackHelper(nums, temp, res, counter);

                // backtrack: remove the num from temp, and add 1 back to the count
                temp.remove(temp.size() - 1);
                counter.put(num, count);
            }
        }
    }
}