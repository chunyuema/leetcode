class Solution:
    def countSubstrings(self, s: str) -> int:
        dp = [[0 for _ in range(len(s))] for _ in range(len(s))]

        # Each character on its own is a palindromic substring
        totalCount = 0
        for i in range(len(s)):
            dp[i][i] = 1
            totalCount += 1
        
        # Check from smaller length to the largest length
        for length in range(1, len(s)):
            # Use the length to determine the start and end index i, j
            for i in range(len(s) - length):
                j = i + length
                # If the character i, j match, and the string from i+1 to j-1 is a substring
                # Then another new palindromic substring can be formed, increment the result
                if s[i] == s[j]:
                    if i + 1 == j or dp[i+1][j-1] == 1: 
                        dp[i][j] = 1
                        totalCount += 1
        
        return totalCount