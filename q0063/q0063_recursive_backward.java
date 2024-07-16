class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final int m = obstacleGrid.length; 
        final int n = obstacleGrid[0].length; 
        int[][] memo = new int[m][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        memo[0][0] = 1;
        return dpHelper(obstacleGrid, m-1, n-1, memo);
    }

    // Let dpHelper(i, j) return the unique paths from 0, 0 to i, j
    private int dpHelper(final int[][] grid, int i, int j, int[][] memo) {
        // Base case: There is 0 unique ways to get to an obstacle
        if (grid[i][j] == 1) return 0; 

        // Memoized case: 
        if (memo[i][j] != -1) return memo[i][j];

        // Recursive cases: 
        int paths = 0; 
        if (i - 1 >= 0) paths += dpHelper(grid, i - 1, j, memo);
        if (j - 1 >= 0) paths += dpHelper(grid, i, j - 1, memo);

        memo[i][j] = paths;
        return memo[i][j];
    }
}