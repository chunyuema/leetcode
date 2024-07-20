class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dpHelper(s, 0, wordDict, memo);
    }

    // Let dpHelper represent if you can successfully segment the string s starting from currIdx
    private boolean dpHelper(String s, int currIdx, List<String> wordDict, int[] memo) {
        // Base case there is no need to match if the currIdx is already at the end of the string
        if (currIdx == s.length()) return true; 

        // Memoized case
        if (memo[currIdx] != -1) return memo[currIdx] == 1;

        // Recursive case
        
        for (final String word : wordDict) {
            // Check if any of the word in the dictionary works
            int nextIdx = currIdx + word.length();
            if (nextIdx <= s.length() && 
                word.equals(s.substring(currIdx, nextIdx)) &&
                dpHelper(s, nextIdx, wordDict, memo)) {
                    memo[currIdx] = 1;
                    return true;
            }
        }
        memo[currIdx] = 0;

        return false;
    }
}