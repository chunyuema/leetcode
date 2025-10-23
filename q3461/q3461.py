class Solution:
    def hasSameDigits(self, s: str) -> bool:
        n = len(s)
        digitList = [int(d) for d in s]
        for i in range(1, n - 1):
            for j in range(n - i):
                d1 = digitList[j]
                d2 = digitList[j+1]
                digitList[j] = (d1 + d2) % 10
        return digitList[0] == digitList[1]
