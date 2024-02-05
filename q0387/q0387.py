class Solution:
    def firstUniqChar(self, s: str) -> int:
        charCount = Counter(s)
        for i in range(len(s)): 
            if charCount[s[i]] == 1: 
                return i
        return -1