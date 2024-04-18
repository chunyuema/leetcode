class Solution {
    private int perimeter;
    private int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    break;
                }
            }
        }
        return perimeter;
    }

    private void dfs(int[][] grid, int x, int y) {
        // based case if outside the boundary / not island
        if (x >= grid.length || x < 0 ||
                y >= grid[0].length || y < 0 ||
                grid[x][y] == 0) {
            perimeter++;
            return;
        }

        // if explored: return
        if (grid[x][y] == -1)
            return;

        // mark the current cell as explored
        grid[x][y] = -1;
        for (int[] dir : dirs) {
            dfs(grid, x + dir[0], y + dir[1]);
        }
    }
}