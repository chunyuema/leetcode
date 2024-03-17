class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();

        for (int[] currInterval : intervals) {
            // If the current interval ends before the new interval
            if (currInterval[1] < newInterval[0]) {
                // Add the current interval and move on
                mergedIntervals.add(currInterval);
            }

            // If the current interval ends after the new interval
            else if (currInterval[0] > newInterval[1]) {
                // Add the new interval and set the current interval as new interval
                mergedIntervals.add(newInterval);
                newInterval = currInterval;
            }

            // If the current interval has interference with the new interval
            else {
                // Merge the intervals
                newInterval[0] = Math.min(currInterval[0], newInterval[0]);
                newInterval[1] = Math.max(currInterval[1], newInterval[1]);
            }
        }
        mergedIntervals.add(newInterval);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}