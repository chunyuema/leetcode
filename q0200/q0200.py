class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        self.dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        self.count = 0
        for i in range(len(grid)): 
            for j in range(len(grid[0])):
                if grid[i][j] == "1": 
                    self.count += 1
                    self.dfs(grid, i, j)

        return self.count
        
    def dfs(self, grid, x, y):
        if (x < 0 or x >= len(grid)) or (y < 0 or y >= len(grid[0])) or grid[x][y] != "1":
            return
        
        grid[x][y] = "#"
        for (dx, dy) in self.dirs:
            self.dfs(grid, x+dx, y+dy)