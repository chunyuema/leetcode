class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());

        int[] memo = new int[words.length];

        int maxLen = 1;
        for (int i = 0; i < words.length; i++) {
            maxLen = Math.max(dpHelper(words, i, memo), maxLen);
        }

        return maxLen;
    }

    private int dpHelper(String[] words, int i, int[] memo) {
        // base case: if i = 0, the longest sequence is just 1
        if (i == 0)
            return 1;

        // memoized case: if we have previously computed it, just return the answer
        if (memo[i] != 0)
            return memo[i];

        // recursive case
        int ans = 1;
        for (int j = 0; j < i; j++) {
            if (isPredecessor(words[j], words[i])) {
                ans = Math.max(dpHelper(words, j, memo) + 1, ans);
            }
        }

        // put the ans in memo before returning the ans
        memo[i] = ans;
        return ans;
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