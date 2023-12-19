class Solution {
    public int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 },
            { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;

        int[][] smoothedImg = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = img[i][j];
                int count = 1;
                for (int[] dir : dirs) {
                    int newI = i + dir[0];
                    int newJ = j + dir[1];
                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n) {
                        sum += img[newI][newJ];
                        count++;
                    }
                }
                smoothedImg[i][j] = sum / count;
            }
        }
        return smoothedImg;
    }
}