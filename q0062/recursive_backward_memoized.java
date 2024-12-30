class Solution {
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for (int[] row : memo) Arrays.fill(row, -1); 
        return dpHelper(m-1, n-1);
    }

    private int[][] memo; 

    // let dpHelper(i, j) return # of unique paths from origin
    private int dpHelper(int i, int j) {
        // Base case: If you are at bottom-right corner, only 1 solution
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) return 0;

        // Memoized case: 
        if (memo[i][j] != -1) return memo[i][j];

        // Recursive cases:
        int fromRowAbove = dpHelper(i-1, j);
        int fromColumnLeft  = dpHelper(i, j-1);
        
        // Cache the result
        memo[i][j] = fromRowAbove + fromColumnLeft;
        return memo[i][j];
    }
}
