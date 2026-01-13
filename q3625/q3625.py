class Solution:
    def countTrapezoids(self, points: List[List[int]]) -> int:
        n = len(points)
        # slope to a list of y intercepts with the given slope value
        # use to count all trapezoids
        slope_map = defaultdict(list)

        # mid points to a list of slopes with such midpoints
        # used to deduplicate the double counted parallelogram
        midpoint_map = defaultdict(list)

        for i in range(n):
            x1, y1 = points[i]
            for j in range(i+1, n):
                x2, y2 = points[j]
                dx, dy = x2 - x1, y2 - y1
                if dx != 0:
                    s = dy / dx
                    # avoid using s to prevent float operations
                    b = (y1 * dx - x1 * dy) / dx
                else:
                    s = inf
                    b = x1
                slope_map[s].append(b)
                mid = (x1 + x2, y1 + y2)
                midpoint_map[mid].append(s)
        
        res = 0
        # first count all the trapezoids
        for intercepts in slope_map.values():
            if len(intercepts) == 1: continue
            c = Counter(intercepts)
            acc = 0
            for count in c.values():
                res += acc * count
                acc += count
        
        # then remove the double counted parallelogram
        for slopes in midpoint_map.values():
            if len(slopes) == 1: continue
            c = Counter(slopes)
            acc = 0
            for count in c.values():
                res -= acc * count
                acc += count
        
        return res
