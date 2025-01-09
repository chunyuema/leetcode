class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        memo = new int[m][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        
        // The result will store the side length of the largest square found
        int maxSquareSide = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxSquareSide = Math.max(maxSquareSide, dpHelper(matrix, i, j));
            }
        }
        
        return maxSquareSide * maxSquareSide; // Return the area
    }

    private int[][] memo;

    // dpHelper returns the max square side length ending at (i, j)
    private int dpHelper(char[][] matrix, int i, int j) {
        // Base case: 
        if (i == 0 || j == 0) return matrix[i][j] == '1' ? 1 : 0;
        // If we've already computed the value, return it
        if (memo[i][j] != -1) return memo[i][j];

        memo[i][j] = 0;
        // If the current cell is '1', compute the largest square size
        if (matrix[i][j] == '1') {
            int up = dpHelper(matrix, i - 1, j);
            int left = dpHelper(matrix, i, j - 1);
            int diagonal = dpHelper(matrix, i - 1, j - 1);
            memo[i][j] = 1 + Math.min(Math.min(up, left), diagonal); // side length of the largest square ending at (i, j)
        }

        return memo[i][j];
    }
}
