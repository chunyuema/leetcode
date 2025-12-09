class Solution:
    def specialTriplets(self, nums: List[int]) -> int:
        left_count = Counter()
        right_count = Counter(nums)
        MOD = 10 ** 9 + 7
        res = 0
        for num in nums:
            # remove num from right_count
            right_count[num] -= 1

            target = num * 2
            # number of target in the left side of the array
            l = left_count[target]
            # number of target in the right side of the array
            r  = right_count[target]
            # compute the total possible combinations + update the result
            res = (res + l * r) % MOD

            # add num to before_count
            left_count[num] += 1
            
        return res       
