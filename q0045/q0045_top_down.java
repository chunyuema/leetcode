class Solution {
    public int jump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dpHelper(nums, nums.length - 1, memo);
    }

    private int dpHelper(int[] nums, int i, int[] memo) {
        if (i == 0)
            return 0;
        if (memo[i] != -1)
            return memo[i];

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < i; j++) {
            if (j + nums[j] >= i) {
                int ans = dpHelper(nums, j, memo);
                if (ans != Integer.MAX_VALUE)
                    res = Math.min(res, ans + 1);
            }
        }

        memo[i] = res;
        return res;
    }
}