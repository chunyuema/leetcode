class Solution {
    public int minSteps(int n) {
        int[][] memo = new int[n][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dpHelper(n, 1, 0, 0, memo); 
    }

    private int dpHelper(int n, int curr, int copied, int steps, int[][] memo) {
        if (curr > n) return Integer.MAX_VALUE;
        if (curr == n) return steps;

        // memoized step
        if (memo[curr][copied] != -1) return memo[curr][copied];

        // recursive steps: 
        int copy = Integer.MAX_VALUE;
        if (curr != copied) copy = dpHelper(n, curr, curr, steps + 1, memo);

        int paste = Integer.MAX_VALUE;
        if (copied != 0) paste = dpHelper(n, curr + copied, copied, steps + 1, memo); 

        // add to memo
        memo[curr][copied] = Math.min(copy, paste);
        return memo[curr][copied];
    }
}