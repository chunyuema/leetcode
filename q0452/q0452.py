class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort()
        total = 1
        prevEnd = points[0][1]
        for i in range(1, len(points)):
            currStart, currEnd = points[i]
            
            # If this current start is before previous end, there is no need to shoot another arrow
            # Update the previous end in case the current end is smaller
            if currStart <= prevEnd: 
                prevEnd = min(prevEnd, currEnd)

            # If this current start is after previous end, then we need to shoot one arrow at the end of previous end
            # Update the previous end to be the value of current end
            else:
                prevEnd = currEnd
                total += 1
        return total