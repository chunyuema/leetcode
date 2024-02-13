class Solution:
    def firstPalindrome(self, words: List[str]) -> str:
        for word in words: 
            if self.checkPalindrome(word): 
                return word
        return ""
        
    def checkPalindrome(self, word):
        l = 0
        r = len(word)-1
        while l <= r: 
            if (word[l] != word[r]): 
                return False
            l += 1
            r -= 1
        return True