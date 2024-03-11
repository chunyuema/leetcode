class Solution:
    def customSortString(self, order: str, s: str) -> str:
        # Build the frequency map
        charCount = defaultdict(int)
        for char in s: 
            charCount[char] += 1 

        res = ""
        # Use the character from the order sequence to build the res
        for char in order: 
            if char in charCount:
                res += char * charCount[char]
                charCount[char] = 0
        
        # Use the rest of the characters
        for char, count in charCount.items(): 
            res += char * count
        return res