class Solution:
    # dimension reduction which achieves the same result
    def robDimensionReductio(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        elif n == 2:
            return max(nums[0], nums[1])

        prevPrevHouse = nums[0]
        prevHouse = max(nums[0], nums[1])

        for i in range(2, n):
            currHouse = max(prevPrevHouse + nums[i], prevHouse)
            prevPrevHouse = prevHouse
            prevHouse = currHouse
        return max(prevHouse, prevPrevHouse)