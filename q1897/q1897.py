class Solution:
    def makeEqual(self, words: List[str]) -> bool:
        charMap = defaultdict(int)
        for word in words: 
            for char in word: 
                charMap[char] += 1
        
        expectedCount = len(words)
        for count in charMap.values(): 
            if count % expectedCount != 0: 
                return False
        return True