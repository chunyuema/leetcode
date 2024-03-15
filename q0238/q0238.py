class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefixProducts = [0 for _ in nums]
        prefixProducts[0] = nums[0]
        for i in range(1, len(nums)): 
            prefixProducts[i] = prefixProducts[i-1] * nums[i]
        
        suffixProducts = [0 for _ in nums]
        suffixProducts[-1] = nums[-1]
        for i in range(len(nums)-2, -1, -1):
            suffixProducts[i] = suffixProducts[i+1] * nums[i]
        
        res = [0 for _ in nums]
        for i in range(len(nums)):
            prefix = prefixProducts[i-1] if i > 0 else 1
            suffix = suffixProducts[i+1] if i < len(nums)-1 else 1
            res[i] = prefix * suffix
        return res 