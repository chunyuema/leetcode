class Solution {
    public double champagneTower(int poured, int queryRow, int queryGlass) {
        double[][] amount = new double[102][102];

        // initially pour all the amount into the first glass to simulate where they would go
        amount[0][0] = (double) poured;
        
        for (int r = 0; r < queryRow; r++) {
            for (int c = 0; c <= r; c++) {
                // the amount that a glass will spill over to its left and right can be computed from the equation from below
                double overflowAmount = (amount[r][c] - 1) / 2;

                // if there are indeed anything overflowing, add the overflow amount to the left and right glass
                if (overflowAmount > 0) {
                    amount[r+1][c] += overflowAmount;
                    amount[r+1][c+1] += overflowAmount;
                }
            }
        }

        double res = amount[queryRow][queryGlass];
        return res > 1 ? 1 : res;
    }
}