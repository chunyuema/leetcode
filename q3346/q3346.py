class Solution:
    def maxFrequency(self, nums: List[int], k: int, numOperations: int) -> int:
        nums.sort()
        counter = Counter(nums)
        maxFreq = 0
        # use each number in the nums array as a target to converge on
        for target in range(nums[0], nums[-1] + 1):
            # min(all possible numbers, numOperations + existing numbers)
            currFreq = min(self.getRange(nums, target, k), 
                           counter[target] + numOperations)
            # update the max frequency while enumerating
            maxFreq = max(maxFreq, currFreq)
        return maxFreq
    
    # total number in the nums array that can be made into target by adding [-k, k]
    def getRange(self, nums, target, k):
        left = bisect_left(nums, target - k)
        right = bisect_right(nums, target + k)
        return right - left
