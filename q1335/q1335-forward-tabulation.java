class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int jobNum = jobDifficulty.length;

        // if there are not enough job for at least 1 each day => -1
        if (d > jobNum)
            return -1;

        // let dp(d, jobNum) represent the min difficulty of completing jobNum jobs in d
        // days
        int[][] dp = new int[d][jobNum];

        // initialize the dp array:
        // first compute the min effort needed if there is only 1 day to do everything
        dp[0][0] = jobDifficulty[0];
        for (int j = 1; j < jobNum; j++)
            dp[0][j] = Math.max(jobDifficulty[j], dp[0][j - 1]);

        // compute the min effort to do in all possible i days with j jobs
        for (int i = 1; i < d; i++) {

            // start looping from j-th job where j = i, at least we need i jobs for the
            // first i days
            for (int j = i; j < jobNum; j++) {

                // initalize currDayEffort to be just doing j-th job on day i
                int currDayEffort = jobDifficulty[j];
                // totalEffort = j-th day effort + all the min effort from before
                int totalMinEffort = currDayEffort + dp[i - 1][j - 1];

                // consider all the k-th jobs (i <= k < j), consider k can be a cut point
                // meaning we we do k jobs in i-1 days + j-k jobs on i-th day
                for (int k = j - 1; k >= i; k--) {
                    // this requires update the currDayEffort needed on the i-th day
                    currDayEffort = Math.max(currDayEffort, jobDifficulty[k]);
                    // use the updated currDayEffort to recompute and track the min total effort
                    // possible
                    totalMinEffort = Math.min(totalMinEffort, currDayEffort + dp[i - 1][k - 1]);
                }

                dp[i][j] = totalMinEffort;
            }
        }

        return dp[d - 1][jobNum - 1];
    }
}