class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int res = INT_MAX;
        int n = matrix.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));

        for (int r = n - 1; r >= 0; --r) {
            for (int c = 0; c < n; ++c) {
                if (r == n - 1) {
                    dp[r][c] = matrix[r][c];
                } else if (c == 0) {
                    dp[r][c] = matrix[r][c] + min(dp[r + 1][c], dp[r + 1][c + 1]);
                } else if (c == n - 1) {
                    dp[r][c] = matrix[r][c] + min(dp[r + 1][c], dp[r + 1][c - 1]);
                } else {
                    dp[r][c] = matrix[r][c] + min({dp[r + 1][c - 1], dp[r + 1][c], dp[r + 1][c + 1]});
                }
            }
        }

        // Taking the minimum of the first row
        for (int i = 0; i < n; ++i) {
            res = min(res, dp[0][i]);
        }

        return res;
    }
};