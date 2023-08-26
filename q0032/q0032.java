package q0032;

class Solution {
    public int longestValidParentheses(String s) {
        int longestLength = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 > 0 ? dp[i - 2] : 0) + 2;
                } 
                else // s.charAr(i-1) == ')'
                {
                    // find the possible '(' that matches with the current ')'
                    int matchingOpen = i - dp[i - 1] - 1;
                    if (matchingOpen >= 0 && s.charAt(matchingOpen) == '(') {
                        // part 1: if matching '(' can be found then add 2 to its value
                        dp[i] = dp[i - 1] + 2;

                        // part 2: add the longest valid string prior to the position of the matching valid '('
                        dp[i] += ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                    }

                }
                longestLength = Math.max(longestLength, dp[i]);
            }
        }
        return longestLength;
    }
}
