class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }

        // Sort based on the ending time to consider the jobs that end earlier first
        Arrays.sort(jobs, (j1, j2) -> Integer.compare(j1[1], j2[1]));

        // Let dp[i] represent the max profit up until job i
        int[] dp = new int[n];

        int maxProfit = 0;
        for (int i = 0; i < n; i++) {

            // Look for the compatible jobs (end earlier) with the highest max profit
            int prevMaxProfit = 0;
            for (int j = 0; j < i; j++) {
                if (jobs[j][1] <= jobs[i][0]) {
                    prevMaxProfit = Math.max(prevMaxProfit, dp[j]);
                }
            }

            // Max profit until i is the previous max profit + profit of job i
            dp[i] = prevMaxProfit + jobs[i][2];

            // Update the max profit to track
            maxProfit = Math.max(maxProfit, dp[i]);
        }
        return maxProfit;
    }
}