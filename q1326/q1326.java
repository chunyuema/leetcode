class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, (int)1e9);

        // let dp[i] represents the min num of taps open to cover until i
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            int currRangeStart = Math.max(0, i - ranges[i]);
            int currRangeEnd = Math.min(n, i + ranges[i]);
            // Since current tap can cover all the way until currRangeEnd
            // For all the tap within this range, we can either choose
            // 1. Open the tap to cover until currRangeEnd
            // 2. Do not open the tap, and use the prev min value for cover until currRangeEnd
            for (int j = currRangeStart; j <= currRangeEnd; j++) {
                dp[currRangeEnd] = Math.min(dp[currRangeEnd], dp[j] + 1);
            }
        }

        int res = dp[n];
        return res == (int)1e9 ? -1 : res;
    }
}