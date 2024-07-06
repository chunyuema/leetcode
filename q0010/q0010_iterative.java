class Solution {
    public boolean isMatch(String s, String p) {

        // dp[i][j] represent if s[0 ~ i] can match p[0 ~ j]
        boolean [][] dp = new boolean[s.length()+1][p.length()+1];
        
        // Initializing dp: 
        // 1. Empty string matches with empty pattern
        dp[0][0] = true;
        // 2. Zero-th column initialization: 
        //    ==> All 0 since empty pattern matches with nothing
        // 3. Zero-th row initialization: 
        //    ==> If any character in p is *, it matches every thing from index i-2 to i
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length ; j++) {
                // If both characters match, or if the pattern is . which matches everything
                if (p.charAt(j-1) == '.' || s.charAt(i-1) == p.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                
                else if (p.charAt(j-1) == '*') {
                    // Case 1: Have zero occurences of the char before j
                    // ==> only have to match from s[0 ~ i] and p[0 ~ j-2]
                    dp[i][j] = dp[i][j-2];
                    // Case 2: Have one or more occurences of the char before j
                    if (p.charAt(j-2) == '.' || s.charAt(i-1) == p.charAt(j-2)) {
                        dp[i][j] = dp[i][j] | dp[i-1][j];
                    }
                } 
                
                else {
                    // No operation needed here, keep it as 0
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}