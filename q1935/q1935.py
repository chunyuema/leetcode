class Solution:
    def canBeTypedWords(self, text: str, brokenLetters: str) -> int:
        brokenLetterSet = set(brokenLetters)

        res = 0
        for word in text.split(" "):
            if self.canBeTyped(word, brokenLetterSet):
                res += 1
        return res

    
    def canBeTyped(self, word: str, brokenLetterSet: set) -> bool: 
        for c in word: 
            if c in brokenLetterSet: 
                return False
        return True
        
