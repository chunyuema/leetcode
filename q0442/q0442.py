class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        duplicates = []
        for num in nums: 
            idx = abs(num) - 1
            if nums[idx] > 0: nums[idx] *= -1
            else: duplicates.append(idx + 1)
        return duplicates