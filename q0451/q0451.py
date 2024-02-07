class Solution:
    def frequencySort(self, s: str) -> str:
        charCounts = [(count, char) for (char, count) in Counter(s).items()]
        charCounts.sort(reverse = True)
        res = ""
        for (count, char) in charCounts: 
            res += char * count
        return res