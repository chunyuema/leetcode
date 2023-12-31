class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (d > jobDifficulty.length)
            return -1;
        Map<String, Integer> memo = new HashMap<>();
        return dpHelper(0, d, -1, jobDifficulty, memo);
    }

    private int dpHelper(int i, int daysLeft, int dailyMax, int[] jobDifficulty, Map<String, Integer> memo) {
        // if we ran out of jobs to do, and we still have days left
        if (i == jobDifficulty.length)
            return daysLeft > 0 ? 10000 : 0;

        // if we ran out of days, but still have more jobs to do, th
        if (daysLeft == 0)
            return 10000;

        // check if we have previously considered this
        String key = Integer.toString(i) + ":" + Integer.toString(daysLeft) + ":" + Integer.toString(dailyMax);
        if (memo.containsKey(key))
            return memo.get(key);

        int currJobDifficulty = jobDifficulty[i];
        dailyMax = Math.max(currJobDifficulty, dailyMax);

        // do the job on the current day
        int doJob = dpHelper(i + 1, daysLeft, dailyMax, jobDifficulty, memo);

        // do not do the current job_i, and postpone it to the next day
        int postponeJob = dailyMax + dpHelper(i + 1, daysLeft - 1, -1, jobDifficulty, memo);

        int res = Math.min(doJob, postponeJob);
        key = Integer.toString(i) + ":" + Integer.toString(daysLeft) + ":" + Integer.toString(dailyMax);
        memo.put(key, res);

        return res;
    }
}