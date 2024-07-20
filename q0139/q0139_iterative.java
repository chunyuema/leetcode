class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Let dp[i] represent if string up till index i can be segmented 
        int[] dp = new int[s.length() + 1];
        dp[0] = 1; // Base case: empty string can be segmented
        
        // Iterate through each character of the string s
        for (int i = 1; i <= s.length(); i++) {
            // Iterate through each word in the wordDict
            for (String word : wordDict) {
                int j = i - word.length();
                // Check if the current substring ending at index i can be segmented
                if (j >= 0 && word.equals(s.substring(j, i)) && dp[j] == 1) {
                    dp[i] = 1; // Mark dp[i] as 1 if it can be segmented
                    break; // Break out of the loop to avoid unnecessary checks
                }
            }
        }
        
        // Return true if the entire string can be segmented
        return dp[s.length()] == 1;
    }
}