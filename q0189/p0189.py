class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        l = len(nums)
        k = k % len(nums)
        nums[:] = nums[l - k :] + nums[: l - k]
