class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        res = 0
        visited = set()
        pq = [(0, 0, 0)]
        while pq:
            curr = heappop(pq)
            x = curr[1]
            y = curr[2]
            if (x, y) not in visited:
                visited.add((x, y))
                res = max(res, grid[x][y])
                if (x == len(grid) - 1 and y == len(grid[0]) - 1): return res
                for dir in dirs: 
                    nextX = x + dir[0]
                    nextY = y + dir[1]
                    if (0 <= nextX < len(grid) and
                        0 <= nextY < len(grid[0]) and
                        (nextX, nextY) not in visited): 
                        heappush(pq, (grid[nextX][nextY], nextX, nextY))
        return res