class Solution:
    def maxDistinctElements(self, nums: List[int], k: int) -> int:
        nums.sort()
        prevMin = -math.inf
        distinct = 0
        for num in nums:
            currMin = min(max(num - k, prevMin + 1), num + k)
            if currMin > prevMin: 
                distinct += 1
                prevMin = currMin
        return distinct
