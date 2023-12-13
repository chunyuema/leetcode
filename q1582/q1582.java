class Solution {
    public int numSpecial(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int[] rowRecord = new int[r];
        int[] colRecord = new int[c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 1) {
                    rowRecord[i]++;
                    colRecord[j]++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 1 && rowRecord[i] == 1 && colRecord[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}