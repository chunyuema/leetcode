class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int[] row : memo)
            Arrays.fill(row, Integer.MAX_VALUE);

        int minPathSum = Integer.MAX_VALUE;

        // Loop through all possible starting position and compute the answer
        for (int j = 0; j < matrix[0].length; j++) {
            minPathSum = Math.min(minPathSum, dpHelper(matrix, 0, j, memo));
        }
        return minPathSum;
    }

    // Let dpHelper(i, j) represents the minPathSum if start from position i, j
    private int dpHelper(int[][] matrix, int i, int j, int[][] memo) {

        // Base case:
        // If the column index becomes invalid, return infinity to rule out the case
        if (j < 0 || j >= matrix[0].length)
            return Integer.MAX_VALUE;

        // If already at last row, the min path sum is just the cell
        if (i == matrix.length - 1)
            return matrix[i][j];

        // Memoized case:
        // If the result has been previously computed, return it from the memo
        if (memo[i][j] != Integer.MAX_VALUE)
            return memo[i][j];

        // Recursive case: either go down, or go down left, or go down right
        int down = dpHelper(matrix, i + 1, j, memo);
        int downLeft = dpHelper(matrix, i + 1, j - 1, memo);
        int downRight = dpHelper(matrix, i + 1, j + 1, memo);

        // Memoize the result for future reference
        int res = matrix[i][j] + Math.min(down, Math.min(downLeft, downRight));
        memo[i][j] = res;
        return res;
    }
}