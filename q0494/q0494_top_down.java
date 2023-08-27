class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return dpHelper(nums, 0, 0, target, memo);
    }

    private int dpHelper(int[] nums, int i, int currSum, int target, Map<List<Integer>, Integer> memo) {
        // base case: if we have explored this currSum at i before, return the solution
        List<Integer> key = Arrays.asList(i, currSum);
        if (memo.containsKey(key)) return memo.get(key);
        
        // recursive case: either add the current number and move on, or subtrack the current and move on
        // recursively let dpHelper compute the value for next states: (i+1, currSum+nums[i]) (i+1, currSum-nums[i]) 
        if (i == nums.length) return currSum == target ? 1 : 0;
        int res = dpHelper(nums, i+1, currSum+nums[i], target, memo) 
                + dpHelper(nums, i+1, currSum-nums[i], target, memo);
        memo.put(Arrays.asList(i, currSum), res);
        return res;
    }
}