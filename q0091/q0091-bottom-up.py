class Solution:
    def numDecodings(self, s: str) -> int:
        if not s or s[0] == '0': return 0

        # initialize the dp array
        n = len(s)
        dp = [0] * (n + 1)
        dp[0] = 1
        
        for i in range(1, n+1):
            # if see '0', and if the char before it and form  0 < num <= 26
            if (s[i-1] == '0'): 
                # need to check s[i-2 : i] to adjust for the index in s
                if (0 < int(s[i-2 : i]) <= 26):
                    dp[i] += dp[i-2]

            # if we do not see '0', try to decode the string  
            else:
                # decode the current one
                dp[i] += dp[i-1]
                
                # try to decode two (the char before cannot be '0')
                if i - 1 > 0 and s[i-2] != '0':
                    # need to check s[i-2 : i] to adjust for the index in s
                    if (0 < int(s[i-2 : i]) <= 26): 
                        dp[i] += dp[i-2]
        return dp[-1]