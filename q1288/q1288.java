import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> {
            if (i1[0] == i2[0]) {
                return Integer.compare(i2[1], i1[1]);
            } else {
                return Integer.compare(i1[0], i2[0]);
            }
        });

        int res = 0;
        int prevEnd = -1;
        for (int[] interval : intervals) {
            int newEnd = interval[1];
            if (newEnd <= prevEnd) {
                res += 1;
            } else {
                prevEnd = newEnd;
            }
        }
        return intervals.length - res;
    }
}