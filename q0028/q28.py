class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        l = len(needle)
        if l > len(haystack):
            return -1
        for i in range(len(haystack) - l + 1):
            if haystack[i : i + l] == needle:
                return i
        return -1
