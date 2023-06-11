package q0005;

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return "";
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i + 1);
            int ans = Math.max(len1, len2);
            if (ans > r - l) {
                l = i - (ans - 1) / 2;
                r = i + ans / 2;
            }
        }
        return s.substring(l, r + 1);
    }

    private int expandFromCenter(String s, int l, int r) {
        if (s.length() == 0 || l > r)
            return 0;
        while (l >= 0 &&
                r < s.length() &&
                s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}