class Solution {
    public int longestStrChain(String[] words) {
        // Sort words by their length (shortest to longest)
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int[] memo = new int[words.length];
        Arrays.fill(memo, -1);

        // Note that since dpHelper(i) represents the longest possible word from index i
        // It is possible that the longest possible chain can start from any index
        int maxChainLength = 0;
        for (int i = 0; i < words.length; i++) {
            maxChainLength = Math.max(maxChainLength, dpHelper(words, i, memo));
        }
        return maxChainLength;
    }

    // Let dpHelper(i) represent the longest possible word chain starting from index i
    private int dpHelper(String[] words, int i, int[] memo) {
        // Base case
        if (i == words.length) return 1; 

        // Memoized case
        if (memo[i] != -1) return memo[i];

        // Recursive case: 
        // dpHelper(i) = 1 + for max (all dpHelper(j) such that words[i] is a predecessor of words[j])
        memo[i] = 1;
        for (int j = i + 1; j < words.length; j++) {
            // Check if words[i] is a predecessor of words[j]
            if (isPredecessor(words[i], words[j])) {
                memo[i] = Math.max(memo[i], 1 + dpHelper(words, j, memo));
            }
        }
        return memo[i];
    }

    // Check if s1 is a predecessor of s2
    private boolean isPredecessor(String s1, String s2) {
        if (s1.length() + 1 != s2.length()) return false;
        
        int i = 0, j = 0;
        boolean foundDifference = false;
        
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                if (foundDifference) return false;
                foundDifference = true;
                j++;
            }
        }
        
        return true;
    }
}