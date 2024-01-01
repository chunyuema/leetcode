class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cookieIndex = 0;
        int childIndex = 0;
        while (cookieIndex < s.length && childIndex < g.length) {
            // try to use the smallest cookie to match the current kid with smallest greed
            if (s[cookieIndex] >= g[childIndex]) {
                childIndex++;
            }
            // update the cookieIndex
            // case 1: satisfied the kid and need a new cookie for the next kid
            // case 2: kid's greed factor larger than current cookie, need a bigger cookie
            cookieIndex++;
        }
        return childIndex;
    }
}