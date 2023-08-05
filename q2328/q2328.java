class Solution {
    public int countPaths(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        int totalPaths = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                totalPaths = (totalPaths + dpHelper(grid, memo, i, j, 0)) % 1000000007;
            }
        }
        return totalPaths;
    }

    private int dpHelper(int[][] grid, int[][] memo, int i, int j, int prevNum) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return 0;
        if (grid[i][j] <= prevNum)
            return 0;
        if (memo[i][j] != 0)
            return memo[i][j];

        int currNum = grid[i][j];
        int up = dpHelper(grid, memo, i, j - 1, currNum);
        int down = dpHelper(grid, memo, i, j + 1, currNum);
        int left = dpHelper(grid, memo, i - 1, j, currNum);
        int right = dpHelper(grid, memo, i + 1, j, currNum);

        memo[i][j] = (1 + up + down + left + right) % 1000000007;
        return memo[i][j];
    }
}