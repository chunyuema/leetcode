class Solution:
    def findXSum(self, nums: List[int], k: int, x: int) -> List[int]:
        n = len(nums)
        count = defaultdict(int)
        answer = []

        for i, num in enumerate(nums):
            # Expand window
            count[num] += 1

            # Shrink window when it's too large
            if i >= k:
                old = nums[i - k]
                count[old] -= 1
                if count[old] == 0: del count[old]

            # Once we have a full window, compute the x-sum
            if i + 1 >= k:
                # Sort items by frequency (descending), then by value (descending)
                sortedItems = sorted(count.items(), key=lambda p: (-p[1], -p[0]))
                xSum = sum([num * val for num, val in sortedItems[:x]])
                answer.append(xSum)
        return answer
