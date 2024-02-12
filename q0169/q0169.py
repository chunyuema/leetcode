class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        numCount = defaultdict(int)
        n = len(nums)
        for num in nums:
            numCount[num] += 1
            if (numCount[num] > n / 2): 
                return num
        return -1