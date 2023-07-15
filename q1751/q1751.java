class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (e1, e2) -> e1[0] - e2[0]);

        int[][] memo = new int[events.length][k + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        return dpHelper(0, events, k, memo);
    }

    private int dpHelper(int currIdx, int[][] events, int k, int[][] memo) {
        if (k == 0 || currIdx == events.length)
            return 0;

        if (memo[currIdx][k] != -1)
            return memo[currIdx][k];

        // attend the current event, and recursively compute from the next possible
        // start time
        int nextCompatibleEventIndex = findNextCompatibleEventIndex(events, events[currIdx][1]);
        int val1 = events[currIdx][2] + dpHelper(nextCompatibleEventIndex, events, k - 1, memo);

        // do not attend the event, and recursively compute from the next immediate
        // start time
        int val2 = dpHelper(currIdx + 1, events, k, memo);

        memo[currIdx][k] = Math.max(val1, val2);
        return memo[currIdx][k];
    }

    private int findNextCompatibleEventIndex(int[][] events, int currEndTime) {
        int l = 0;
        int r = events.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (events[m][0] <= currEndTime) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}