class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Let dp[i] represent if string up till index i can be segmented 
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            for (final String word : wordDict) {
                int j = i - word.length();
                if (j >= 0 && 
                    word.equals(s.substring(j, i)) &&
                    dp[j] == 1) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[s.length()] == 1;
    }
}