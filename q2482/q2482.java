class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[] rowOneCount = new int[r];
        int[] rowZeroCount = new int[r];
        int[] colOneCount = new int[c];
        int[] colZeroCount = new int[c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    rowOneCount[i]++;
                    colOneCount[j]++;
                } else {
                    rowZeroCount[i]++;
                    colZeroCount[j]++;
                }
            }
        }

        int[][] diff = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                diff[i][j] = rowOneCount[i] + colOneCount[j] - rowZeroCount[i] - colZeroCount[j];
            }
        }
        return diff;
    }
}