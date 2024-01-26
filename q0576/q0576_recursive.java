class Solution {
    private final int mod = 1000000007;
    private final int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] memo = new int[m][n][maxMove + 1];
        for (int[][] matrix : memo) {
            for (int[] row : matrix)
                Arrays.fill(row, -1);
        }
        return dpHelper(m, n, maxMove, startRow, startColumn, memo);
    }

    // Let dpHelper represent the total ways of getting out if we start from
    // currRow, and currCol with x moves left
    private int dpHelper(int m, int n, int movesLeft, int currRow, int currColumn, int[][][] memo) {
        // Base case: If go outside the grid, return 1 because it is the one way to go
        // outside
        if (currRow < 0 || currRow >= m || currColumn < 0 || currColumn >= n)
            return 1;

        // Base case: If we do not make it out before running out of moves, return 0
        if (movesLeft == 0)
            return 0;

        // Memoized case
        if (memo[currRow][currColumn][movesLeft] != -1)
            return memo[currRow][currColumn][movesLeft];

        // Recursive case: compute the sum of all 4 directions
        int total = 0;
        for (int[] dir : dirs) {
            int nextRow = currRow + dir[0];
            int nextColumn = currColumn + dir[1];
            total = (total + dpHelper(m, n, movesLeft - 1, nextRow, nextColumn, memo)) % mod;
        }

        // Keep the memo for future references
        memo[currRow][currColumn][movesLeft] = total;
        return total;
    }
}