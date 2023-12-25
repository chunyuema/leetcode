class Solution:
    def numDecodings(self, s: str) -> int:
        if not s or s[0] == '0': return 0
        oneBefore = 1
        twoBefore = 1
        for i in range(1, len(s)):
            curr = 0
            if s[i] != '0': curr += oneBefore
            if s[i-1] != '0' and int(s[i-1 : i+1]) <= 26: curr += twoBefore
            oneBefore, twoBefore = curr, oneBefore
        return oneBefore