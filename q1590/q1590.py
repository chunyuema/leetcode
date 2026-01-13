class Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:
        n = len(nums)
        total_sum = sum(nums)  # total sum of the array

        # The "extra" amount modulo p that we need to remove
        target = total_sum % p
        if target == 0: 
            return 0  # already divisible, no need to remove anything

        # Dictionary to store the last index where a particular prefix sum modulo p occurred
        mod_idx = {0: -1}  # sum 0 occurs at index -1 (before array starts)
        curr_mod = 0  # running prefix sum modulo p
        min_len = n  # initialize min_len to the max possible

        for i, num in enumerate(nums):
            curr_mod = (curr_mod + num) % p  # update prefix sum modulo p

            # Calculate the prefix modulo we need to have seen before
            # so that removing the subarray between that index + 1 and i gives sum divisible by p
            needed_mod = (curr_mod - target + p) % p

            # If we have seen this modulo before, a valid subarray exists
            if needed_mod in mod_idx:
                last_mod_idx = mod_idx[needed_mod]
                min_len = min(min_len, i - last_mod_idx)  # update minimum length

            # Record the last index where this curr_mod occurred
            mod_idx[curr_mod] = i

        # If min_len was not updated, return -1. Otherwise, return min_len.
        return -1 if min_len == n else min_len

