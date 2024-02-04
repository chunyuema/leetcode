class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        memo = [-1 for _ in range(len(arr))]
        return self.dpHelper(arr, k, 0, memo)
        
    # let dpHelper return the max after partitioning if we start from index start
    def dpHelper(self, arr, k, start, memo): 
        # base case: return 0 if start goes out of the boundary
        if start >= len(arr): return 0

        # memoized case: if we have already computed this solution
        if memo[start] != -1: return memo[start]

        # recursive case: initialize the current subarray max as arr[start]
        currMax = arr[start]
        res = 0
        for end in range(start, min(len(arr), start + k)):
            # Update the current subarray max
            currMax = max(currMax, arr[end])

            # compute the current subarry sum
            subarraySum = (end - start + 1) * currSubarrayMax

            # recursively compute the result if start from index end+1
            res = max(res, subarraySum + self.dpHelper(arr, k, end + 1, memo))
        
        memo[start] = res
        return res