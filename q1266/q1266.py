class Solution:
    def minTimeToVisitAllPoints(self, points: List[List[int]]) -> int:
        min_time = 0
        for i in range(1, len(points)):
            prev = points[i-1]
            curr = points[i]
            min_time += max(abs(curr[0] - prev[0]),
                            abs(curr[1] - prev[1]))
        return min_time        
