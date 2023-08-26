class Solution {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dpHelper(memo, nums, target);
    }


    private int dpHelper(Map<Integer, Integer> memo, int[] nums, int target) {
        // base case: if target = 0; target = 1; or target has already been computed
        if (target == 0) return 1;
        if (target < 0)  return 0;
        if (memo.containsKey(target)) return memo.get(target);

        // recursive case: accumulate the sum of dpHelper on target - num for all num from nums
        // this is hence a top down approach, as we assume that we know the result for dpHelper on a smaller target
        int totalCombination = 0;
        for (int num : nums) {
            totalCombination += dpHelper(memo, nums, target - num);
        }

        memo.put(target, totalCombination);
        return totalCombination;
    }
}