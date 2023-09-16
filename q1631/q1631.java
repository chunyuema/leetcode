class Solution {
    private int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minimumEffortPath(int[][] heights) {
        int[][] efforts = new int[heights.length][heights[0].length];
        for (int[] row : efforts)
            Arrays.fill(row, Integer.MAX_VALUE);
        efforts[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[] { 0, 0, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currEffort = curr[0];
            int i = curr[1];
            int j = curr[2];

            // early stopping logic that could improve the perf
            // if (currEffort > efforts[i][j]) continue;
            // if (i == heights.length - 1 && j == heights[0].length - 1) return currEffort;

            for (int[] d : directions) {
                int nextI = i + d[0];
                int nextJ = j + d[1];
                if (nextI >= 0 && nextI < heights.length && nextJ >= 0 && nextJ < heights[0].length) {
                    int nextEffort = Math.max(currEffort, Math.abs(heights[nextI][nextJ] - heights[i][j]));
                    if (nextEffort < efforts[nextI][nextJ]) {
                        efforts[nextI][nextJ] = nextEffort;
                        pq.add(new int[] { nextEffort, nextI, nextJ });
                    }
                }
            }
        }

        return efforts[heights.length - 1][heights[0].length - 1];
    }
}