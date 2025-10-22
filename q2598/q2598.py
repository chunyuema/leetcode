class Solution:
    def findSmallestInteger(self, nums: List[int], value: int) -> int:
        remainderCount = defaultdict(int)
        for num in nums: 
            remainder = num % value
            remainderCount[remainder] += 1
        
        # Try to build MEX starting from 0 upwards
        start = 0
        while remainderCount[start % value] > 0:
            # If we have at least one number of this remainder class
            remainderCount[start % value] -= 1  # Use it to represent `start`
            start += 1
        
        # Can't represent this number, so MEX is `start`
        return start
