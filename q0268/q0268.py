class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        res = len(nums)
        for i in range(len(nums)): 
            num = nums[i]
            res ^= (num ^ i)
        return res