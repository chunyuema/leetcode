class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        vowels = set(['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'])
        count = 0

        # Increment count in the first half
        for i in range(0, len(s) // 2):
            if s[i] in vowels: count += 1

        # Decrement count in the second half
        for i in range(len(s) // 2, len(s)):
            if s[i] in vowels: count -= 1
        
        return count == 0