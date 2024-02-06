class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        res = []
        ele = []
        # k is the number of elements left to add in each quad
        # start is the starting place for the quad
        def helper(k, start, target): 
            # if there are still more than two elements left, then tackle it down to two sum
            if k > 2:
                for i in range(start, len(nums) - k + 1):
                    if i > start and nums[i] == nums[i - 1]:
                        continue
                    ele.append(nums[i])
                    helper(k - 1, i + 1, target - nums[i])
                    ele.pop()
                return
            # this part will be reached when there are two elements left for the quad element
            # this part is the same as two sum problem
            l , r = start, len(nums) - 1
            while l < r:
                if nums[l] + nums[r] > target:
                    r -= 1
                elif nums[l] + nums[r] < target:
                    l += 1
                else:
                    res.append(ele + [nums[l], nums[r]])
                    l += 1
                    while l < r and nums[l] == nums[l - 1]:
                        l += 1
        helper(4, 0, target)
        return res