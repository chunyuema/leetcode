class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        total = 0
        for num in nums: 
            total += (1 if num % 3 != 0 else 0)
        return total
