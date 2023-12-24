class Solution:
    def minOperations(self, s: str) -> int:
        ops = 0
        prevChar = s[0]
        for i in range(1, len(s)):
            currChar = s[i]
            if prevChar == currChar:
                ops += 1
                prevChar = '1' if prevChar == '0' else '0'
            else:
                prevChar = currChar
        return min(ops, len(s) - ops)
        