class Solution:
    def maxIncreasingSubarrays(self, nums: List[int]) -> int:
        indexAndLen = dict()
        l = 0
        for r in range(1, len(nums) + 1):
            # If we're at the end or the sequence stops increasing
            if r == len(nums) or nums[r] <= nums[r - 1]:
                indexAndLen[l] = r - l
                l = r

        maxLen = 0
        for startIndex, subarrayLen in indexAndLen.items():
            # Option 1: Divide the current subarray into 2 subarrays
            maxLen = max(maxLen, subarrayLen // 2)

            # Option 2: If there is another subarray which starts right after the current one
            nextIndex = startIndex + subarrayLen
            if nextIndex in indexAndLen:
                maxLen = max(maxLen, min(indexAndLen[startIndex], indexAndLen[nextIndex]))
        
        return maxLen
