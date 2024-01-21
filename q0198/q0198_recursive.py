class Solution:
    ## using memoization
    def rob(self, nums):
        memo = {}

        def dp(i):
            if i == 0:
                return nums[0]
            if i == 1:
                return max(nums[0], nums[1])
            if i in memo:
                return memo[i]

            ans1 = nums[i] + dp(i - 2)
            ans2 = dp(i - 1)
            res = max(ans1, ans2)
            memo[i] = res
            return res

        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        return dp(len(nums) - 1)
