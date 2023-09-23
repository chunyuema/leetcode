class Solution {
    public int longestStrChain(String[] words) {
        // sort the input string array in the order of length
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());

        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);

        int maxLen = 1;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
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