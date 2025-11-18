class Solution:
    def isOneBitCharacter(self, bits: List[int]) -> bool: 
        i = 0
        n = len(bits)
        while i < n - 1: 
            curr = bits[i]
            i += curr + 1
        return i == n - 1
