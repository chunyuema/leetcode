class Solution:
    def largestSumAfterKNegations(self, nums: List[int], k: int) -> int:
        heapify(nums)
        while k > 0:
            smallest = heappop(nums)
            heappush(nums, -1 * smallest)
            k -= 1
        return sum(nums)
