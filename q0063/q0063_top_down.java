class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dpHelper(m-1, n-1, memo);
    }

    // dpHelper(i, j) represent the number of ways to reach [i, j]
    private int dpHelper(int i, int j, int[][] memo) {
        if (i == 0 || j == 0) return 1;
        if (memo[i][j] != -1) return memo[i][j];

        memo[i][j] = dpHelper(i-1, j, memo) + dpHelper(i, j-1, memo);
        return memo[i][j];
    } 
}