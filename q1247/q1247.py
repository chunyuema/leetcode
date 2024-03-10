class Solution:
    def minimumSwap(self, s1: str, s2: str) -> int:
        xMismatch = 0
        yMismatch = 0
        for i in range(len(s1)):
            if s1[i] == 'x' and s2[i] == 'y': xMismatch += 1 
            if s1[i] == 'y' and s2[i] == 'x': yMismatch += 1
        
        # Impossible case: the number of mismatches in x and y must be both even or both odd
        if xMismatch % 2 != yMismatch % 2: return -1

        # Apply xx yy swap as many as possible
        oneSwaps = xMismatch // 2 + yMismatch // 2

        # Apply xy yx  2 swaps only when necessary (finish the rest of the cases)
        twoSwaps = xMismatch % 2
        return 1 * oneSwaps + 2 * twoSwaps