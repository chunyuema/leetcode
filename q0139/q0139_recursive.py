class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        memo = {}
        return self.dpHelper(s, wordDict, 0, memo)
    

    # Let dpHelper(i) = True if we can build towards the end starting from index i
    def dpHelper(self, s, wordDict, i, memo):

        # Base case: if i == len(s) there is nothing left to take care, so yes we can 
        if i == len(s): return True

        # Memoized case: if we have previously checked dpHelper(i)
        if i in memo: return memo[i]

        # By default, we start with cannot build until the last index
        memo[i] = False
        # Loop through every word, if the word can be used
        # Calculate the next index j to recursively call dpHelper(j)
        for word in wordDict: 
            j = i + len(word)
            if (s[i:j] == word and self.dpHelper(s, wordDict, j, memo)): 
                memo[i] = True
                # If any word works, break immediately as there is no point exploring more
                break
                
        return memo[i]