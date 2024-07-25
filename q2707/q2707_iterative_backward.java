class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        // Let dp[i] represent the min extra char up until index i
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; 

        // Create a dictionary set for quick look up of words
        Set<String> dictionarySet= new HashSet<>(Arrays.asList(dictionary));


        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                
                // Case 1: From s[j, i), no extra char is generated as there is a match
                // Case 2: From s[j, i), i-j extra characters are generated due to mismatch
                int misMatch = dictionarySet.contains(word) ? 0 : (i - j);

                // The number of mismatches generated added to the dp[i]
                dp[i] = Math.min(dp[i], dp[j] + misMatch);
            }
        }

        return dp[s.length()];
    }
}