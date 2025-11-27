class Solution:
    def maxSubarraySum(self, nums: List[int], k: int) -> int:
        # Maps (prefix_length % k) -> smallest prefix sum seen so far
        prefix_min = {0: 0}

        prefix_sum = 0
        max_sum = float("-inf")

        for i, num in enumerate(nums):
            prefix_sum += num

            # The modulo group for this prefix length
            group = (i + 1) % k

            if group in prefix_min:
                # We can form a valid subarray ending at i with length % k == 0
                smallest_prev_prefix = prefix_min[group]
                current_subarray_sum = prefix_sum - smallest_prev_prefix
                max_sum = max(max_sum, current_subarray_sum)

                # Update the stored minimum prefix sum for this group
                prefix_min[group] = min(prefix_min[group], prefix_sum)
            else:
                # First time we see this group → store prefix_sum
                prefix_min[group] = prefix_sum

        return max_sum
