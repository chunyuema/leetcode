class Solution:
    def countPartitions(self, nums: List[int], k: int) -> int:
        n = len(nums)
        mod = 10**9 + 7

        # dp[i] = number of valid ways to partition nums[:i]
        dp = [0] * (n + 1)

        # prefix[i] = sum(dp[0] + dp[1] + ... + dp[i]) % mod
        # Used for fast range-sum DP queries.
        prefix = [0] * (n + 1)

        # A multiset (balanced BST) to maintain sliding-window min/max.
        window = SortedList()

        # Base: one way to partition an empty prefix.
        dp[0] = 1
        prefix[0] = 1

        j = 0  # left pointer for the sliding window

        for i in range(n):
            # Insert nums[i] into the sliding window
            window.add(nums[i])

            # Shrink window from the left while max - min > k
            # cnt[-1] is max, cnt[0] is min
            while j <= i and window[-1] - window[0] > k:
                window.remove(nums[j])
                j += 1

            # All valid partitions must have their last segment starting at any
            # index t where j <= t <= i.
            # That segment is nums[t : i+1].
            # Number of ways for that = sum(dp[t]) for t in [j, i]
            # prefix helps compute this range sum in O(1):
            # sum(dp[j] + ... + dp[i]) = prefix[i] - prefix[j-1]
            dp[i + 1] = (prefix[i] - (prefix[j - 1] if j > 0 else 0)) % mod

            # Update prefix sum for dp
            prefix[i + 1] = (prefix[i] + dp[i + 1]) % mod

        # Answer: number of ways to partition full array nums[:n]
        return dp[n]
