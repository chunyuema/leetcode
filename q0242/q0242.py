class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t): return False

        charMapS = [0] * 26
        charMapT = [0] * 26
        
        for i in range(len(s)):
            charMapS[ord(s[i])-ord('a')] += 1
            charMapT[ord(t[i])-ord('a')] += 1
        
        return charMapS == charMapT