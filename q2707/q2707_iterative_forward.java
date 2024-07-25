class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[s.length() + 1];
        Set<String> dictionarySet= new HashSet<>(Arrays.asList(dictionary));
        

        for (int i = s.length()-1; i >= 0; i--) {
            // skip the current character, and make it one of the leftovers
            int skip = dp[i+1] + 1;

            // do not skip the current character, try to find a word to match
            int noSkip = Integer.MAX_VALUE;
            for (int j = i; j < s.length(); j++) {
                String subString = s.substring(i, j+1);
                if (dictionarySet.contains(subString)) {
                    noSkip = Math.min(noSkip, dp[j+1]);
                }
            }

            dp[i] = Math.min(skip, noSkip);
        }
        
        return dp[0];
    }
}