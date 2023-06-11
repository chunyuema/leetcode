class Solution:
    def appendCharacters(self, s: str, t: str) -> int:
        ps = 0
        pt = 0
        while ps != len(s) and pt != len(t):
            if s[ps] == t[pt]:
                pt += 1
            ps += 1
        return len(t) - pt
