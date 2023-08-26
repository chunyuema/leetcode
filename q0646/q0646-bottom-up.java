class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (p1, p2) -> p1[0] - p2[0]);
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);

        int maxLen = 1;
        for (int i = 0; i < pairs.length; i++) {
            int[] currPair = pairs[i];
            for (int j = 0; j < i; j++) {
                int[] prevPair = pairs[j];
                if (currPair[0] > prevPair[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }

        return maxLen;
    }
}