class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x: (x[0], -x[1]))
        res = 0
        prev_end = -1

        for interval in intervals:
            if interval[1] <= prev_end:
                res += 1
            else:
                prev_end = interval[1]

        return len(intervals) - res
