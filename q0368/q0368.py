class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        res = []
        nums.sort()
        # Let dp[i] represent the largest subset up until index i
        dp = [[nums[i]] for i in range(len(nums))]
        for i in range(len(nums)): 
            currNum = nums[i]
            for j in range(i):
                prevNum = nums[j]
                if currNum % prevNum == 0 and len(dp[j]) + 1 > len(dp[i]):
                    dp[i] = dp[j] + [currNum]
            # Update the globally tracked res to reflect the largest subset so far
            res = dp[i] if len(dp[i]) > len(res) else res
        return res