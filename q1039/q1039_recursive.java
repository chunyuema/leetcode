class Solution {
    public int minScoreTriangulation(int[] values) {
        int[][] memo = new int[values.length][values.length];
        for (int[] row : memo) Arrays.fill(row, Integer.MAX_VALUE);
        // We could pick the starting and ending index randomly as long as they cover all the points in the polygon
        return dpHelper(values, 0, values.length-1, memo);
    }

    // Let dpHelper represent the min score with start and end as the starting and ending index
    private int dpHelper(final int[] values, int start, int end, int[][] memo) {
        // Base case 1: Cannot triangulate
        if (end - start < 2) return 0;
        // Base case 2: Only one possibility to triangulate
        if (end - start == 2) return values[start] * values[start+1] * values[end];

        // Memoized step: 
        if (memo[start][end] != Integer.MAX_VALUE) return memo[start][end];

        // Recursive Step: Pick a middle point, and the recurse on the left and right sides
        for (int i = start + 1; i < end; i++) {
            int score = values[start] * values[i] * values[end];
            memo[start][end] = Math.min(memo[start][end], 
                        score + dpHelper(values, start, i, memo) + dpHelper(values, i, end, memo));
        }

        return memo[start][end];
    }
}