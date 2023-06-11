class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        elif n == 2:
            return max(nums[0], nums[1])
        maxMoney = [0] * n
        maxMoney[0] = nums[0]
        maxMoney[1] = max(nums[0], nums[1])
        for i in range(2, n):
            res1 = nums[i] + maxMoney[i - 2]
            res2 = maxMoney[i - 1]
            maxMoney[i] = max(res1, res2)
        return maxMoney[-1]

    # dimension reduction which achieves the same result
    def robDimensionReductio(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        elif n == 2:
            return max(nums[0], nums[1])

        ans1 = nums[0]
        ans2 = max(nums[0], nums[1])
        res = 0
        for i in range(2, n):
            res = max(ans1 + nums[i], ans2)
            ans1 = ans2
            ans2 = res
        return res

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
