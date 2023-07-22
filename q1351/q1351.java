class Solution {
    public int countNegatives(int[][] grid) {
        int firstNegativeIdx = grid[0].length - 1;
        int totalNegatives = 0;
        for (int[] row : grid) {
            // find the first negative index from this row
            while (firstNegativeIdx >= 0 && row[firstNegativeIdx] < 0) {
                firstNegativeIdx--;
            }
            // compute the number of negative numbers in this row
            totalNegatives += row.length - firstNegativeIdx - 1;
        }
        return totalNegatives;
    }
}