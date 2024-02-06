class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return getKSum(nums, target, 4, 0);
    }

    private List<List<Integer>> getKSum(int[] nums, long target, int k, int start) {
        List<List<Integer>> res = new ArrayList<>();

        // Base case: If we ran out of numbers, just return the res
        if (start == nums.length)
            return res;

        // Base case: If we need to find just two sum, it reduces to finding two sum
        if (k == 2)
            return getTwoSum(nums, target, start);

        for (int i = start; i < nums.length; i++) {
            // If the current num is just a repeating num, skip it to avoid duplication
            if (i != start && nums[i - 1] == nums[i])
                continue;

            // Pick the number at current i, recursively find the answers for the new target
            for (List<Integer> numList : getKSum(nums, target - nums[i], k - 1, i + 1)) {
                List<Integer> ans = new ArrayList<Integer>();
                ans.add(nums[i]);
                ans.addAll(numList);
                res.add(ans);
            }
        }

        return res;
    }

    public List<List<Integer>> getTwoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int l = start, r = nums.length - 1;

        while (l < r) {
            int currSum = nums[l] + nums[r];

            if (currSum < target || (l > start && nums[l] == nums[l - 1]))
                l++;

            else if (currSum > target || (r < nums.length - 1 && nums[r] == nums[r + 1]))
                r--;

            else {
                res.add(Arrays.asList(nums[l++], nums[r--]));
            }
        }

        return res;
    }
}