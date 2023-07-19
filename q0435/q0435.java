class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int res = 0;
        int prevEndTime = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int newStartTime = intervals[i][0];
            int newEndTime = intervals[i][1];
            if (newStartTime >= prevEndTime) {
                prevEndTime = newEndTime;
            } else {
                res++;
            }
        }
        return res;
    }
}
