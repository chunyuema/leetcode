class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        firstMax = float("-inf")
        secondMax = float("-inf")
        for num in nums: 
            if num > firstMax: 
                secondMax = max(firstMax, secondMax)
                firstMax = num
            elif num > secondMax: 
                secondMax = num
        return (firstMax - 1) * (secondMax - 1)
        