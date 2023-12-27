class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int[] dp = new int[n];

        char prevColor = colors.charAt(0);
        int prevMinTime = neededTime[0];
        for (int i = 1; i < n; i++) {
            char currColor = colors.charAt(i);
            int currTime = neededTime[i];

            // if currColor is equal to prevColor, then we need to remove
            if (currColor == prevColor) {
                // remove the color which requires minimum time needed to remove the currColor
                dp[i] = dp[i - 1] + Math.min(currTime, prevMinTime);
                // update the minimum time needed to remove currColor in case we need to remove
                // again
                prevMinTime = Math.max(currTime, prevMinTime);
            } else {
                // there is no need to remove anything
                dp[i] = dp[i - 1];
                // update the prevColor and prevMinTime as we are looking at a different color
                // now
                prevColor = currColor;
                prevMinTime = currTime;
            }
        }
        return dp[n - 1];
    }
}