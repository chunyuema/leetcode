class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] memo = new int[days.length];
        Arrays.fill(memo, -1);  // Initialize memoization array with -1 (indicating not calculated)
        return dpHelper(days, costs, days.length - 1, memo);
    }

    // dpHelper(i) returns the min cost of tickets to cover from days[0] until days[i]
    private int dpHelper(int[] days, int[] costs, int i, int[] memo) {
        // Base case: If we've covered all days up to the first one, return 0 (no cost)
        if (i < 0) return 0;
        
        // If the result is already memoized, return it
        if (memo[i] != -1) return memo[i];

        int currDay = days[i];
        
        // Option 1: Arriving on the current day because we bought a 1-day ticket on currDay-1
        int buy1Day = costs[0] + dpHelper(days, costs, getIndex(days, currDay - 1), memo);

        // Option 2: Arriving on the current day because we bought a 7-day ticket on currDay-7
        int buy7Day = costs[1] + dpHelper(days, costs, getIndex(days, currDay - 7), memo);

        // Option 3: Arriving on the current day because we bought a 30-day ticket on currDay-30
        int buy30Day = costs[2] + dpHelper(days, costs, getIndex(days, currDay - 30), memo);

        // Take the minimum cost from the 3 options
        memo[i] = Math.min(buy1Day, Math.min(buy7Day, buy30Day));

        return memo[i];
    }

    // getIndex finds the rightmost day in 'days' array that is <= targetDay using binary search
    private int getIndex(int[] days, int targetDay) {
        int i = 0;
        int j = days.length - 1;
        // Perform binary search to find the rightmost day that is <= targetDay
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (days[m] > targetDay) {
                j = m - 1;  // If the day is greater than targetDay, we need a smaller index
            } else {
                i = m + 1;  // If the day is less than or equal to targetDay, move to the next range
            }
        }
        // Return the index of the last day that is <= targetDay
        return j;
    }
}

