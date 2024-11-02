class Solution {
    public int maxMoves(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for (int[] row : memo) Arrays.fill(row, -1);

        int currMax = 0;
        for (int i = 0; i < grid.length; i++) {
            currMax = Math.max(currMax, dpHelper(grid, i, 0, memo));
        }
        return currMax;
    }


    // Let dpHelper return the max number of moves if you start from index i, j
    private int dpHelper(int[][] grid, int i, int j, int[][] memo) {
        // Base case: if we reach the last column, return 0 (no further moves)
        if (j == grid[0].length - 1) {
            return 0;
        }

        // Memoized case: if you have previously calculated the max number of moves, return
        if (memo[i][j] != -1) return memo[i][j];

        int maxMoves = 0;
        // Explore the next positions: right, down-right, and up-right
        for (int nextI = i - 1; nextI <= i + 1; nextI++) {
            int nextJ = j + 1;
            if (nextI >= 0 && nextI < grid.length && nextJ < grid[0].length) {
                if (grid[nextI][nextJ] > grid[i][j]) {
                    // Recursively explore the next position and track max moves
                    maxMoves = Math.max(maxMoves, dpHelper(grid, nextI, nextJ, memo) + 1);
                }
            }
        }

        memo[i][j] = maxMoves;
        return maxMoves; // Return the maximum moves found
    }
}
