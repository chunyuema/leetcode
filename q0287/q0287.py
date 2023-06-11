class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        for num in nums:
            idx = abs(num)
            if nums[idx - 1] < 0:
                return idx
            nums[idx - 1] *= -1
        return -1
