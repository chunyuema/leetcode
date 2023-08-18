class Solution {

    private int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        for (int[] arr : res)
            Arrays.fill(arr, Integer.MAX_VALUE);

        // Use queue for BFS. The cells with zeros are ready to be explored
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    queue.offer(new int[] { i, j });
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] currCell = queue.poll();
            int currRow = currCell[0];
            int currCol = currCell[1];
            for (int[] d : directions) {
                int nextRow = currRow + d[0];
                int nextCol = currCol + d[1];
                // If the explored cell index is within the boundary
                if (nextRow >= 0 && nextRow < mat.length && nextCol >= 0 && nextCol < mat[0].length) {
                    // If a new shorter path to the cell has been found, update its value, and add
                    // it back to the queue
                    if (res[nextRow][nextCol] > res[currRow][currCol] + 1) {
                        res[nextRow][nextCol] = res[currRow][currCol] + 1;
                        queue.offer(new int[] { nextRow, nextCol });
                    }
                }
            }
        }

        return res;
    }
}