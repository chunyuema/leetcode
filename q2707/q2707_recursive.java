class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Integer[] memo = new Integer[s.length()];
        return dpHelper(s, 0, new HashSet<>(Arrays.asList(dictionary)), memo);
    }

    // Let dpHelper(i) represent the number of ways to break string s starting from index i
    private int dpHelper(String s, int i, Set<String> dictionarySet, Integer[] memo) {
        // Base case: if we are already at the end of the string s
        if (i == s.length()) return 0;

        // Memoized case: if we have previously computed dpHelper(i)
        if (memo[i] != null) return memo[i];
        
        // Recursive cases: 
        // Case 1: skip the current character, and make it one of the leftovers
        int skip = dpHelper(s, i+1, dictionarySet, memo) + 1;

        // Case 2: do not skip the current character, try to find a word to match
        int noSkip = Integer.MAX_VALUE;
        for (int j = i; j < s.length(); j++) {
            // try to find the substring, if the substring can be found, compute noSkip and update the value
            String subString = s.substring(i, j+1);
            if (dictionarySet.contains(subString)) {
                noSkip = Math.min(noSkip, dpHelper(s, j+1, dictionarySet, memo));
            }
        }

        memo[i] = Math.min(skip, noSkip);
        return memo[i];
    }
}