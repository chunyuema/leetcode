class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // prepare the memo for the dpHelper
        int[][] memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        return dpHelper(m - 1, n - 1, grid, memo);
    }

    private int dpHelper(int i, int j, int[][] grid, int[][] memo) {
        // Base cases:
        if (i == 0 && j == 0)
            return grid[i][j];

        // catches the function call that has invalid i / j
        // this happens when calling dpHelper from the first column / row
        if (i < 0 || j < 0)
            return Integer.MAX_VALUE;

        // use memoized value to prevent time complexity
        if (memo[i][j] != -1)
            return memo[i][j];

        // Two recursive cases, one from going to right, and one from going to left.
        memo[i][j] = grid[i][j] + Math.min(dpHelper(i - 1, j, grid, memo), dpHelper(i, j - 1, grid, memo));
        return memo[i][j];
    }
}