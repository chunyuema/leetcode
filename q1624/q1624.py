class Solution:
    def maxLengthBetweenEqualCharacters(self, s: str) -> int:
        firstIndexMap = {}
        maxLen = -1
        for i in range(len(s)): 
            if s[i] in firstIndexMap:
                maxLen = max(maxLen, i - firstIndexMap[s[i]] - 1)
            else: 
                firstIndexMap[s[i]] = i
        return maxLen