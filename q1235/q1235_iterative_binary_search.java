class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }

        // Sort based on the ending time to consider the jobs that end earlier first
        Arrays.sort(jobs, (j1, j2) -> Integer.compare(j1[1], j2[1]));

        // Let dp[endTime] represent the max profit with end time at endTime
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);

        int maxProfit = 0;
        for (int[] job : jobs) {

            // Get previously max profit that does not conflict with the current start time
            int prevMaxProfit = dp.floorEntry(job[0]).getValue();

            // Update the max profit when the new max profit candiate
            maxProfit = Math.max(maxProfit, job[2] + prevMaxProfit);

            // Update the dp tree map to record the max profit achivable until current job i
            dp.put(job[1], maxProfit);
        }
        return maxProfit;
    }
}