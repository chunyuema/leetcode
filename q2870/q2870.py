class Solution:
    def minOperations(self, nums: List[int]) -> int:
        numCount = Counter(nums)
        totalOps = 0
        for count in numCount.values(): 
            # cannot be eliminiated by any operations
            if count == 1: return -1

            # use the operation to eliminate as many groups of 3 as possible
            # only the left over 1 pair is eliminated with the operation to remove pair
            totalOps += ceil(count / 3)
        return totalOps