class Solution {
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for (int[] row : memo) Arrays.fill(row, -1); 
        return dpHelper(0, 0, m, n);
    }

    private int[][] memo; 

    // let dpHelper(i, j) return # of unique paths to destination
    private int dpHelper(int i, int j, int m, int n) {
        // Base case: If you are at bottom-right corner, only 1 solution
        if (i == m-1 && j == n-1) return 1;
        if (i >= m || j >= n) return 0;

        // Memoized case: 
        if (memo[i][j] != -1) return memo[i][j];

        // Recursive cases:
        int goRight = dpHelper(i+1, j, m, n);
        int goDown  = dpHelper(i, j+1, m, n);
        
        // Cache the result
        memo[i][j] = goRight + goDown;
        return memo[i][j];
    }
}
