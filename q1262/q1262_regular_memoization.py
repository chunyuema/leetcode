class Solution:
    def maxSumDivThree(self, nums: List[int]) -> int:
        memo = dict()
        return self.dp(nums, 0, 0, memo)

    # Represent the max sum with a remainder of r when sum // 3 at idx
    def dp(self, nums, i, curr_remainder, memo):
        # Base case: If final remainder is exactly r, valid sum is 0 if r==0 else -inf
        if i == len(nums):
            return 0 if curr_remainder == 0 else float('-inf')
        
        # Memoized case
        if (i, curr_remainder) in memo: 
            return memo[(i, curr_remainder)]
        
        # Option 1: take the number, update the remainder
        num = nums[i]
        new_remainder = (curr_remainder + num) % 3
        take = num + self.dp(nums, i+1, new_remainder, memo)
        
        # Option 2: skip the number: no change to remainder
        skip = self.dp(nums, i+1, curr_remainder, memo)

        res = max(take, skip)
        memo[(i, curr_remainder)] = res
        
        return res
