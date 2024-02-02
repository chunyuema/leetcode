class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // Let dp[i] represent the min cost of tickets until index i
        int[] dp = new int[days.length + 1];

        for (int i = 1; i <= days.length; i++) {
            // To arrive at the current day, there are three possible cases:
            int currDay = days[i - 1];

            // Case 1: Bought a one day ticket no later than currDay - 1
            int lastPurchase1 = dp[getIndex(days, currDay - 1)] + costs[0];

            // Bought a 7 day ticket no later than currDay - 7
            int lastPurchase7 = dp[getIndex(days, currDay - 7)] + costs[1];

            // Bought a 30 day ticket no later than currDay - 30
            int lastPurchase30 = dp[getIndex(days, currDay - 30)] + costs[2];

            dp[i] = Math.min(lastPurchase1, Math.min(lastPurchase7, lastPurchase30));
        }
        return dp[days.length];
    }

    // Get the index of the day when we needed to buy a ticket
    private int getIndex(int[] days, int targetDay) {
        int i = 0;
        int j = days.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (days[m] <= targetDay) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return j + 1;
    }
}