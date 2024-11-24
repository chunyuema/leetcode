class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        int negativeCount = 0;
        long minNum = Long.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                long currNum = matrix[i][j];
                if (currNum < 0) negativeCount++;
                totalSum += Math.abs(currNum);
                minNum = Math.min(minNum, Math.abs(currNum));
            }
        }
        return negativeCount % 2 == 0 ? totalSum : totalSum - (2 * minNum);
    }
}