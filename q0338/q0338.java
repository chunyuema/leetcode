class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        int offset = 1;
        for (int i = 1; i <= n; i++) {
            offset = (i == offset * 2) ? i : offset;
            res[i] = res[i-offset] + 1;
        }
        return res;
    }
}