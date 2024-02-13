class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // Sort the array to provide necessary condition getting two sums
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // Move on to the next num, if the current num repeats with before
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // Get the twoSum starting from i+1, each pair can form a triplet with the
            // current num
            for (List<Integer> pair : twoSum(nums, 0 - nums[i], i + 1)) {
                List<Integer> triplet = new ArrayList<>();
                triplet.add(nums[i]);
                triplet.addAll(pair);
                res.add(triplet);
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int l = start;
        int r = nums.length - 1;
        while (l < r) {
            int currSum = nums[l] + nums[r];
            if (currSum > target || (r < nums.length - 1 && nums[r] == nums[r + 1])) {
                r--;
            } else if (currSum < target || (l > start && nums[l] == nums[l - 1])) {
                l++;
            } else {
                res.add(Arrays.asList(nums[l], nums[r]));
                l++;
                r--;
            }
        }
        return res;
    }
}