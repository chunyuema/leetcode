#include <vector>
using namespace std;

class Solution
{
public:
    int countPaths(vector<vector<int>> &grid)
    {
        vector<vector<int>> memo(grid.size(), vector<int>(grid[0].size(), 0));
        int totalPaths = 0;
        for (int i = 0; i < grid.size(); i++)
        {
            for (int j = 0; j < grid[0].size(); j++)
            {
                totalPaths = (totalPaths + dpHelper(i, j, 0, grid, memo)) % 1000000007;
            }
        }
        return totalPaths;
    }

    int dpHelper(int i, int j, int prev, vector<vector<int>> &grid, vector<vector<int>> &memo)
    {
        // if the previous cell does not lie in the grid, return 0
        if (i < 0 || j < 0 || i >= grid.size() || j >= grid[0].size())
            return 0;

        // if current grid number is less than previous number, return 0 as this breaks the linearly increasing order
        if (grid[i][j] <= prev)
            return 0;

        // if the memo[i][j] has been previously computed, there is no need to compute again.
        if (memo[i][j] != 0)
            return memo[i][j];

        // recursively compute the number of paths leading to dp[i, j].
        int up = dpHelper(i, j + 1, grid[i][j], grid, memo);
        int down = dpHelper(i, j - 1, grid[i][j], grid, memo);
        int left = dpHelper(i + 1, j, grid[i][j], grid, memo);
        int right = dpHelper(i - 1, j, grid[i][j], grid, memo);
        memo[i][j] = (1 + up + down + left + right) % 1000000007;
        return memo[i][j];
    }
};