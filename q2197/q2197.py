class Solution:
    def replaceNonCoprimes(self, nums: List[int]) -> List[int]:
        res = [nums[0]]
        for curr in nums[1:]:
            prev = res[-1]
            # check co-prime
            if (math.gcd(curr, prev) == 1):
                res.append(curr)
            # keep merging until no more co-prime
            else:
                merge = math.lcm(curr, prev)
                while res and math.gcd(res[-1], merge) != 1:
                    merge = math.lcm(res.pop(), merge)
                res.append(merge)
        return res