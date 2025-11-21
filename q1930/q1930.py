class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        char_info = dict()
        for i, c in enumerate(s):
            if c not in char_info:
                char_info[c] = [i, -1]
            else:
                char_info[c][1] = i
        
        total = 0
        for char, [l, r] in char_info.items():
            unique = set()
            for i in range(l+1, r):
                unique.add(s[i])
            total += len(unique)
            
        return total
