class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res = 0
        # Count of the arrays with a particular prefixSum
        prefixSumCount = defaultdict(int)
        currPrefixSum = 0
        for num in nums: 
            currPrefixSum += num

            # Case 1: when currPrefixSum happens to be equal to k
            if currPrefixSum == k: res += 1
            
            # Case 2: Get the count of all arrays with prefix sum = current prefix sum - k
            # Since current prefix sum - (current prefix sum - k) = k,
            # the ends of arrays with prefix sum = current prefix sum - k
            # will form subarray of sum k with current index i
            prevPrefixSum = currPrefixSum - k
            prevPrefixSumCount = prefixSumCount[prevPrefixSum]
            res += prevPrefixSumCount

            prefixSumCount[currPrefixSum] += 1
        return res