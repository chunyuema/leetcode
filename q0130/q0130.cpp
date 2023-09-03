class Solution
{
public:
    void solve(vector<vector<char>> &board)
    {
        int m = board.size();
        int n = board[0].size();
        for (int r = 0; r < m; r++)
        {
            for (int c = 0; c < n; c++)
            {
                if (r == 0 or c == 0 or r == m - 1 or c == n - 1)
                {
                    if (board[r][c] == 'O')
                    {
                        captureNonSurroundedRegions(board, r, c, m, n);
                    }
                }
            }
        }

        for (int r = 0; r < m; r++)
        {
            for (int c = 0; c < n; c++)
            {
                if (board[r][c] == 'O')
                {
                    board[r][c] = 'X';
                }
            }
        }

        for (int r = 0; r < m; r++)
        {
            for (int c = 0; c < n; c++)
            {
                if (board[r][c] == 'T')
                {
                    board[r][c] = 'O';
                }
            }
        }
    }

    void captureNonSurroundedRegions(vector<vector<char>> &board, int r, int c, int m, int n)
    {
        if (r < 0 or c < 0 or
            r == m or c == n or
            board[r][c] != 'O')
        {
            return;
        }
        board[r][c] = 'T';
        captureNonSurroundedRegions(board, r + 1, c, m, n);
        captureNonSurroundedRegions(board, r - 1, c, m, n);
        captureNonSurroundedRegions(board, r, c + 1, m, n);
        captureNonSurroundedRegions(board, r, c - 1, m, n);
    }
};