class Solution:
    def maxScore(self, s: str) -> int:
        totalOnes = s.count("1")

        left = 1 if s[0] == "0" else 0
        right = totalOnes - 1 if s[0] == "1" else totalOnes
        maxScore = left + right
        for i in range(1, len(s)-1):
            if s[i] == "1":
                right -= 1
            else: 
                left += 1
                maxScore = max(maxScore, left + right)
        return maxScore

