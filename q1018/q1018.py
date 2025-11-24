class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        # maintain the running numeric number
        curr = 0
        res = []
        for num in nums: 
            curr = (curr << 1) + num
            # curr = (curr * 2) + num
            res.append(curr % 5 == 0)
        return res
