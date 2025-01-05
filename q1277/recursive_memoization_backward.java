class Solution {
    
    private int[][] memo;

    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Initialize memoization table with -1
        memo = new int[rows][cols];
        for (int[] row : memo) Arrays.fill(row, -1);
        
        int total = 0;
        
        // Fill the memo table and accumulate the total count
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                total += dpHelper(matrix, i, j);
            }
        }
        
        return total;
    }

    // Let dpHelper return the size of the largest square submatrix ending at (i, j)
    private int dpHelper(int[][] matrix, int i, int j) {
        // Base case: If out of bounds, it's not a square matrix
        if (i < 0 || j < 0) return 0;

        // Base case: If 1st row / 1st column, the square matrix ending at (i, j) is at most 1
        if (i == 0 || j == 0) return matrix[i][j] == 1 ? 1 : 0;
        
        // Memoized case: If already computed, return the memoized value
        if (memo[i][j] != -1) return memo[i][j];
        
        // Recursive case: If the cell itself is 1, calculate the size of the largest square submatrix ending at (i, j)
        memo[i][j] = 0;
        if (matrix[i][j] == 1) {
            memo[i][j] = 1 + Math.min(Math.min(dpHelper(matrix, i - 1, j), 
                                        dpHelper(matrix, i, j - 1)), 
                                        dpHelper(matrix, i - 1, j - 1));
        } 

        return memo[i][j];
    }
}

