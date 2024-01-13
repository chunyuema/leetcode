class Solution:
    def minSteps(self, s: str, t: str) -> int:
        count = [0] * 26
        for c in s: 
            count[ord(c) - ord('a')] += 1
        
        for c in t:
            if count[ord(c) - ord('a')] != 0: 
                count[ord(c) - ord('a')] -= 1
        
        return sum(count)