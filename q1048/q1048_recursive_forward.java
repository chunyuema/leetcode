class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());

        int[] memo = new int[words.length];

        // Note that since dpHelper(i) represents the longest possible word from index i
        // It is possible that the longest possible chain can start from any index
        int maxLen = 0;
        for (int i = 0; i < words.length; i++) {
            maxLen = Math.max(dpHelper(words, i, memo), maxLen);
        }

        return maxLen;
    }

    // Let dpHelper(i) represent the longest chain up until index i
    private int dpHelper(String[] words, int i, int[] memo) {
        // base case: if i = 0, the longest sequence is just 1
        if (i == 0) return 1;

        // memoized case: if we have previously computed it, just return the answer
        if (memo[i] != 0) return memo[i];

        // recursive case
        // dpHelper(i) = 1 + for max (all dpHelper(j) such that words[j] is a predecessor of words[i])
        memo[i] = 1;
        for (int j = 0; j < i; j++) {
            if (isPredecessor(words[j], words[i])) {
                memo[i] = Math.max(memo[i], dpHelper(words, j, memo) + 1);
            }
        }

        return memo[i];
    }

    // return if s1 is a valid precessor of s2
    private boolean isPredecessor(String s1, String s2) {
        if (s1.length() + 1 != s2.length())
            return false;
        int p1 = 0;
        int p2 = 0;
        while (p2 < s2.length()) {
            if (p1 < s1.length() && s1.charAt(p1) == s2.charAt(p2)) {
                p1++;
                p2++;
            } else {
                p2++;
            }
        }
        return p1 + 1 == p2;
    }
}