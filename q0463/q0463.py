class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        self.perimeter = 0
        self.dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        for i in range(len(grid)): 
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    self.dfs(grid, i, j)
                    break
        return self.perimeter

    def dfs(self, grid, x, y): 
        # if go out of bound / encounter water, perimeter += 1
        if (x < 0 or x >= len(grid)) or (y < 0 or y >= len(grid[0])) or (grid[x][y] == 0): 
           self.perimeter += 1
           return
        
        # if the cell has been visited, skip
        if grid[x][y] == -1: return

        # mark the cell as visited, and recursively call dfs
        grid[x][y] = -1
        for (dx, dy) in self.dirs: 
            self.dfs(grid, x + dx, y + dy)
        