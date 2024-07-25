class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Integer[] memo = new Integer[s.length()];
        return dpHelper(s, 0, new HashSet<>(Arrays.asList(dictionary)), memo);
    }


    private int dpHelper(String s, int i, Set<String> dictionarySet, Integer[] memo) {
        if (i == s.length()) return 0;
        if (memo[i] != null) return memo[i];
        
        // skip the current character, and make it one of the leftovers
        int skip = dpHelper(s, i+1, dictionarySet, memo) + 1;

        // do not skip the current character, try to find a word to match
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