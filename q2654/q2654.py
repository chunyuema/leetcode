import math
from typing import List

class Solution:
    def minOperations(self, nums: List[int]) -> int:
        n = len(nums)
        # The array already has at least one '1', Each non-1 element can be converted to 1 in one operation.
        # So, the minimum number of operations equals the number of non-1 elements.
        if 1 in nums:
            num_ones = nums.count(1)
            return n - num_ones
        # We need to find the shortest subarray whose GCD equals 1.
        # Once we find such a subarray, it tells us how many steps are needed
        # to create the *first* 1. After that, we can spread it to the rest of the array.
        min_subarray_length = float('inf')
        for start in range(n):
            gcd_value = nums[start]
            
            # Extend the subarray to the right one element at a time
            for end in range(start + 1, n):
                gcd_value = math.gcd(gcd_value, nums[end])
                
                # As soon as GCD becomes 1, we record this subarray length
                if gcd_value == 1:
                    subarray_length = end - start + 1
                    min_subarray_length = min(min_subarray_length, subarray_length)
                    break  # No need to extend further; longer subarray won't be shorter
        # No subarray has GCD == 1
        if min_subarray_length == float('inf'):
            return -1
        # Compute total operations = (min_subarray_length - 1): steps to create the first 1
        # (n - 1): steps to spread that 1 to all elements
        total_operations = (min_subarray_length - 1) + (n - 1)
        return total_operations

