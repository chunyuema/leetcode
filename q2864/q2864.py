class Solution:
    def maximumOddBinaryNumber(self, s: str) -> str:
        numOfOnes = 0 
        for c in s: 
            if c == '1': 
                numOfOnes += 1
        
        res = "1" * (numOfOnes-1) + "0" * (len(s) - numOfOnes) + "1"

        return res