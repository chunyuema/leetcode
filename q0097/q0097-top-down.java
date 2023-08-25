class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        // mark them as unexplored
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) Arrays.fill(memo[i], -1);
        
        return dpHelper(s1, s2, s3, 0, 0, memo);
    }

    private boolean dpHelper(String s1, String s2, String s3, int p1, int p2, int[][] memo){
        if (p1 + p2 == s3.length()) return true;
        if (memo[p1][p2] != -1) return memo[p1][p2] == 1;

        boolean res = false;

        // case 1: get one matching character from s1
        if (p1 < s1.length() && s1.charAt(p1) == s3.charAt(p1+p2)) {
            res |= dpHelper(s1, s2, s3, p1+1, p2, memo);
        }

        // case 2: get one matching character from s2
        if (p2 < s2.length() && s2.charAt(p2) == s3.charAt(p1+p2)) {
            res |= dpHelper(s1, s2, s3, p1, p2+1, memo);
        }

        memo[p1][p2] = res ? 1 : 0;
        return res;
    }
}