class Solution:
    def minPairSum(self, nums: List[int]) -> int:
        nums.sort()
        max_sum = 0
        i = 0
        j = len(nums) - 1
        while i < j:
            max_sum = max(max_sum, nums[i] + nums[j])
            i += 1
            j -= 1
        return max_sum
