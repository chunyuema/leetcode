class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        start = 0
        windowSum = 0
        total = 0
        prefixZeros = 0
        for end, num in enumerate(nums):
            # expand the window 
            windowSum += num

            # shrink the window until requirement is met
            while start < end and (nums[start] == 0 or windowSum > goal):
                if nums[start] == 0: prefixZeros += 1
                else: prefixZeros = 0
                windowSum -= nums[start]
                start += 1
            
            # update total count
            if windowSum == goal: 
                # add 1 and prefixZeros to the total
                # all the prefixZeros do not affect the answer
                total += 1 + prefixZeros
        
        return total