class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        else if (n == 2)
            return Math.max(nums[0], nums[1]);
        int[] maxMoney = new int[n];
        maxMoney[0] = nums[0];
        maxMoney[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int res1 = nums[i] + maxMoney[i - 2];
            int res2 = maxMoney[i - 1];
            maxMoney[i] = Math.max(res1, res2);
        }
        return maxMoney[n - 1];
    }

    public int robDimensionReduction(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        else if (n == 2)
            return Math.max(nums[0], nums[1]);

        int ans1 = nums[0];
        int ans2 = Math.max(nums[0], nums[1]);
        int res = 0;

        for (int i = 2; i < n; i++) {
            res = Math.max(ans1 + nums[i], ans2);
            ans1 = ans2;
            ans2 = res;
        }

        return res;
    }
}