class Solution:
    def maxSumDivThree(self, nums: List[int]) -> int:
        
        # Represent the max sum with a remainder of r when sum // 3 at idx
        @lru_cache(None)
        def dp(i, curr_remainder):
            # Base case: If final remainder is exactly r, valid sum is 0 if r==0 else -inf
            if i == len(nums):
                return 0 if curr_remainder == 0 else float('-inf')
            
            # Option 1: take the number, update the remainder
            num = nums[i]
            new_remainder = (curr_remainder + num) % 3
            take = num + dp(i+1, new_remainder)
            
            # Option 2: skip the number: no change to remainder
            skip = dp(i+1, curr_remainder)
            
            return max(take, skip)
        
        return dp(0, 0)

