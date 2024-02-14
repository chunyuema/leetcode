class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        positiveIndex = 0
        negativeIndex = 1
        res = [0] * len(nums)
        for num in nums: 
            if num > 0: 
                res[positiveIndex] = num
                positiveIndex += 2
            else: 
                res[negativeIndex] = num
                negativeIndex += 2
        return res