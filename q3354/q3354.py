class Solution:
    def countValidSelections(self, nums: List[int]) -> int:
        total = 0
        numsSum = sum(nums)
        for i, num in enumerate(nums):
            if num == 0:
                if self.explore(nums[:], i, 1, numsSum): total += 1
                if self.explore(nums[:], i, -1, numsSum): total += 1
        return total
    
    def explore(self, nums, currIdx, direction, numsSum) -> bool:
        while currIdx >= 0 and currIdx < len(nums):
            if nums[currIdx] > 0:
                # decrement the currIdx value by 1
                nums[currIdx] -= 1
                # decrement tht total sum by 1
                numsSum -= 1

                # reverse direction
                direction = -1 * direction
            
            # take a step in the direction
            currIdx = currIdx + direction

        # only need to check the sum of all elements
        return numsSum == 0
