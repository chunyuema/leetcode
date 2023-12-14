class Solution
{
public:
    vector<vector<int>> onesMinusZeros(vector<vector<int>> &grid)
    {
        int r = grid.size();
        int c = grid[0].size();

        vector<int> rowOneCount(r, 0);
        vector<int> rowZeroCount(r, 0);
        vector<int> colOneCount(c, 0);
        vector<int> colZeroCount(c, 0);

        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                if (grid[i][j] == 1)
                {
                    rowOneCount[i]++;
                    colOneCount[j]++;
                }
                else
                {
                    rowZeroCount[i]++;
                    colZeroCount[j]++;
                }
            }
        }

        vector<vector<int>> diff(r, vector<int>(c, 0));
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                diff[i][j] = rowOneCount[i] + colOneCount[j] -
                             rowZeroCount[i] - colZeroCount[j];
            }
        }
        return diff;
    }
};