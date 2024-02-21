class Solution:
    def rangeBitwiseAnd(self, left: int, right: int) -> int:
        rightShift = 0
        while left != right: 
            left >>= 1
            right >>= 1
            rightShift += 1
        
        # left OR right now represent the common prefix of the
        # binary representation of original left and right number
        return left << rightShift