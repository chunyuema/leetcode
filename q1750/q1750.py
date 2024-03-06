class Solution:
    def minimumLength(self, s: str) -> int:
        left = 0
        right = len(s) - 1
        while left < right: 
            currChar = s[left]
            if currChar != s[right]: break
            while left <= right and currChar == s[left]: left += 1
            while right > left and currChar == s[right]: right -= 1
        return right - left + 1