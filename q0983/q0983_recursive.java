class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] memo = new int[days.length];
        Arrays.fill(memo, -1);
        return dpHelper(days, costs, 0, memo);
    }

    // Let dpHelper(i) return the min cost starting from index i (does not have to
    // be day i)
    private int dpHelper(int[] days, int[] costs, int i, int[] memo) {
        if (i >= days.length)
            return 0;
        if (memo[i] != -1)
            return memo[i];

        int currDay = days[i];

        // buy a 1-day pass on currDay
        int buy1Day = costs[0] + dpHelper(days, costs, getIndex(days, currDay + 1), memo);

        // buy a 7-day pass on currDay
        int buy7Day = costs[1] + dpHelper(days, costs, getIndex(days, currDay + 7), memo);

        // buy a 30-day pass on currDay
        int buy30Day = costs[2] + dpHelper(days, costs, getIndex(days, currDay + 30), memo);

        memo[i] = Math.min(buy1Day, Math.min(buy7Day, buy30Day));
        return memo[i];
    }

    // Get the index of the next day when we need to start buying a ticket
    private int getIndex(int[] days, int targetDay) {
        int i = 0;
        int j = days.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (days[m] >= targetDay) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }
}