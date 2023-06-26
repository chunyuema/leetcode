package q0778;
import java.util.PriorityQueue;

class Solution {
    public int swimInWater(int[][] grid) {
        int res = 0;
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, 0, 0 });
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[1], y = curr[2];
            if (!visited[x][y]) {
                visited[x][y] = true;
                res = Math.max(res, grid[x][y]);
                if (x == n - 1 && y == n - 1) {
                    return res;
                }
                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX >= 0 && newY >= 0 &&
                            newX < n && newY < n &&
                            !visited[newX][newY]) {
                        pq.offer(new int[] { grid[newX][newY], newX, newY });
                    }
                }
            }
        }
        return -1;
    }
}