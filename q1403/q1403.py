class Solution:
    def minSubsequence(self, nums: List[int]) -> List[int]:
        res = []
        nums.sort(reverse = True)
        totalSum = sum(nums)
        currSum = 0
        for num in nums:
            currSum += num
            res.append(num)
            if currSum > totalSum - currSum: 
                break
        return res