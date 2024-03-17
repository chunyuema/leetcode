class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        mergedIntervals = []
        for currInterval in intervals: 
            if newInterval[0] > currInterval[1]:
                mergedIntervals.append(currInterval)
            elif newInterval[1] < currInterval[0]:
                mergedIntervals.append(newInterval)
                newInterval = currInterval
            else: 
                newInterval[0] = min(newInterval[0], currInterval[0])
                newInterval[1] = max(newInterval[1], currInterval[1])
        mergedIntervals.append(newInterval)
        return mergedIntervals