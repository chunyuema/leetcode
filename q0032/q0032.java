package q0032;

class Solution {
    public int longestValidParentheses(String s) {
        int longestLength = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 > 0 ? dp[i - 2] : 0) + 2;
                } else // s.charAr(i-1) == ')'
                {
                    int matchingOpen = i - dp[i - 1] - 1;
                    if (matchingOpen >= 0 && s.charAt(matchingOpen) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        dp[i] += ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                    }

                }
                longestLength = Math.max(longestLength, dp[i]);
            }
        }
        return longestLength;
    }
}
