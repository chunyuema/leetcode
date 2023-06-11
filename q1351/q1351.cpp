#include <vector>
using namespace std;

class Solution
{
public:
    int countNegatives(vector<vector<int>> &grid)
    {
        int res = 0;
        int row_num = grid[0].size();
        int first_negative_index = row_num - 1;
        for (auto &row : grid)
        {
            // find the first time a negative element appear in the row
            while (first_negative_index >= 0 && row[first_negative_index] < 0)
            {
                // the next row's first negative element index will be smaller
                first_negative_index--;
            }
            // update the result
            res += (row_num - (first_negative_index + 1));
        }
        return res;
    }
};