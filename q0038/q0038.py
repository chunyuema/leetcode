class Solution:
    def countAndSay(self, n: int) -> str:
        if n == 1: return "1"
        return self.rleHelper(self.countAndSay(n-1))
    
    def rleHelper(self, s):
        res = []
        count = 1
        prevChar = s[0]
        for i in range(1, len(s)):
            currChar = s[i]
            if prevChar == currChar:
                count += 1
            else: 
                res.append(str(count) + prevChar)
                prevChar = currChar
                count = 1
        res.append(str(count) + prevChar)
        return "".join(res)
