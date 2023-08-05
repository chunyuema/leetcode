class Solution {
    public int countSubstrings(String s) {
        int[][] dp = new int[s.length()][s.length()];

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            res++;
        }

        for (int l = 1; l < s.length(); l++) {
            for (int i = 0; i < s.length() - l; i++) {
                int j = i + l;
                if (s.charAt(i) == s.charAt(j)) {
                    if (l == 1 || (l != 1 && dp[i + 1][j - 1] == 1)) {
                        dp[i][j] = 1;
                        res++;
                    }
                }
            }
        }

        return res;
    }
}