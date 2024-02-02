class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        elif n == 2:
            return max(nums[0], nums[1])
        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, n):
            res1 = nums[i] + dp[i - 2]
            res2 = dp[i - 1]
            dp[i] = max(res1, res2)
        return dp[-1]