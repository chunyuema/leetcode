class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r == 0 || c == 0 || r == m - 1 || c == n - 1) {
                    // Perform DFS starting from the border cells that are marked as 'O'
                    if (board[r][c] == 'O') {
                        captureNonSurroundedRegions(board, r, c, m, n);
                    }
                }
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void captureNonSurroundedRegions(char[][] board, int r, int c, int m, int n) {
        if (r < 0 || c < 0 || r == m || c == n || board[r][c] != 'O')
            return;
        board[r][c] = 'T';
        captureNonSurroundedRegions(board, r + 1, c, m, n);
        captureNonSurroundedRegions(board, r - 1, c, m, n);
        captureNonSurroundedRegions(board, r, c + 1, m, n);
        captureNonSurroundedRegions(board, r, c - 1, m, n);
    }
}