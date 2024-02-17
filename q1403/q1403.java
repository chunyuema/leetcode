class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;

        int currSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            currSum += nums[i];
            res.add(nums[i]);
            if (currSum > totalSum - currSum)
                break;
        }
        return res;
    }
}