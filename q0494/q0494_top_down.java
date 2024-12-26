class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // Memo to track the number of states
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return dpHelper(nums, 0, 0, target, memo);
    }

    // Let dp return the number of ways to build towards target if we start from a given index i
    private int dpHelper(int[] nums, int i, int currSum, int target, Map<List<Integer>, Integer> memo) {
        
        // Base case: if we start from the last index, simply compare the current sum with target
        if (i == nums.length) return currSum == target ? 1 : 0;

        // Memoized case: if we know the answer to reach target from this state: (i, currSum), return that
        List<Integer> state = Arrays.asList(i, currSum);
        if (memo.containsKey(state)) return memo.get(state);
        
        // Recursive case: number of ways to build to target is euqal to the sum of two decisions: + / -
        int res = dpHelper(nums, i+1, currSum+nums[i], target, memo) + dpHelper(nums, i+1, currSum-nums[i], target, memo);
        memo.put(Arrays.asList(i, currSum), res);
        
        return res;
    }
}}
