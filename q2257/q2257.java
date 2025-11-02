class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] graph = new int[m][n];
        for (int[] arr : graph) Arrays.fill(arr, 1);

        for (int[] g : guards) graph[g[0]][g[1]] = -1;
        for (int[] w : walls) graph[w[0]][w[1]] = -2;
        for (int[] g : guards) markGuarded(g[0], g[1], graph);

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) count++;
            }
        }
        return count;
    }

    private void markGuarded(int i, int j, int[][] graph) {
        int up = i - 1;
        while (up >= 0 && graph[up][j] != -1 && graph[up][j] != -2) {
            graph[up][j] = 0;
            up--;
        }

        int down = i + 1;
        while (down < graph.length && graph[down][j] != -1 && graph[down][j] != -2) {
            graph[down][j] = 0;
            down++;
        }

        int left = j - 1;
        while (left >= 0 && graph[i][left] != -1 && graph[i][left] != -2) {
            graph[i][left] = 0;
            left--;
        }

        int right = j + 1;
        while (right < graph[0].length && graph[i][right] != -1 && graph[i][right] != -2) {
            graph[i][right] = 0;
            right++;
        }
    }
}
