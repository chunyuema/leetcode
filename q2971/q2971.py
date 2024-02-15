class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        nums.sort()
        runningSum = nums[0] + nums[1]
        res = -1
        for i in range(2, len(nums)): 
            if runningSum > nums[i]:
                res = runningSum + nums[i]
            runningSum += nums[i]
        return res