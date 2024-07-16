class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final int m = obstacleGrid.length; 
        final int n = obstacleGrid[0].length; 
        int[][] memo = new int[m][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        memo[m-1][n-1] = obstacleGrid[m-1][n-1] == 0 ? 1 : 0;
        return dpHelper(obstacleGrid, 0, 0, memo);
    }

    // Let dpHelper(i, j) return the unique paths from i, j to the bottom right corner
    private int dpHelper(final int[][] grid, int i, int j, int[][] memo) {
        // Base case: No way to start from obstacle and arrive in destination
        if (grid[i][j] == 1) return 0; 

        // Memoized case: 
        if (memo[i][j] != -1) return memo[i][j];

        // Recursive cases: 
        int paths = 0;
        
        // Recursive cases:
        if (i + 1 < grid.length) {
            paths += dpHelper(grid, i + 1, j, memo);
        }
        if (j + 1 < grid[0].length) {
            paths += dpHelper(grid, i, j + 1, memo);
        }
        
        // Update memoization
        memo[i][j] = paths;

        return memo[i][j];
    }
}