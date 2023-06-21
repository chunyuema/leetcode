class Solution:
    def getAverages(self, nums: List[int], k: int) -> List[int]:
        if k == 0:
            return nums

        n = len(nums)
        averages = [-1] * n
        if n < 2 * k + 1:
            return averages

        currentSum = sum(nums[: 2 * k + 1])
        averages[k] = currentSum // (2 * k + 1)

        for j in range(k + 1, n - k):
            l = j - k - 1
            r = j + k
            currentSum = currentSum - nums[l] + nums[r]
            averages[j] = currentSum // (2 * k + 1)

        return averages
