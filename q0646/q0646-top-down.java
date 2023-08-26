class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (p1, p2) -> p1[0] - p2[0]);
        int[] memo = new int[pairs.length];

        int res = 0;
        for (int i = 0; i < pairs.length; i++) {
            res = Math.max(res, dpHelper(pairs, i, memo));
        }

        return res;
    }

    // Conceptually: if we take pairs[i] in the longest chain, then this dpHelper
    // will return the length of this longest chain containing this pairs[i]
    private int dpHelper(int[][] pairs, int i, int[] memo) {
        if (memo[i] != 0) return memo[i];

        memo[i] = 1;
        for (int j = i + 1; j < pairs.length; j++) {
            int[] currPair = pairs[i];
            int[] nextPair = pairs[j];
            if (currPair[1] < nextPair[0]) {
                memo[i] = Math.max(memo[i], 1 + dpHelper(pairs, j, memo));
            }
        }

        return memo[i];
    }
}