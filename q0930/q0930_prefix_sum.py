class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        prefixSum = 0
        prefixSumCount = defaultdict(int)
        total = 0 
        for num in nums: 
            prefixSum += num

            # update the total count by 1 if we find a goal
            if prefixSum == goal: 
                total += 1

            # for all previous prefix sums = prefixSum - goal
            # the current prefix sum can form a subarray of sum goal
            targetSum = prefixSum - goal
            total += prefixSumCount[targetSum]

            # update the count of the prefix sum
            prefixSumCount[prefixSum] += 1
        return total