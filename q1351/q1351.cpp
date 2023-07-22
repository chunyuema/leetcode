class Solution
{
public:
    int countNegatives(vector<vector<int>> &grid)
    {
        int res = 0;
        int first_negative_index = grid[0].size() - 1;
        for (auto &row : grid)
        {
            // find the first time a negative element appear in the row
            while (first_negative_index >= 0 && row[first_negative_index] < 0)
            {
                // the next row's first negative element index will be smaller
                first_negative_index--;
            }
            // update the result
            res += (row.size() - (first_negative_index + 1));
        }
        return res;
    }
};