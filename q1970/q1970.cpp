#include <vector>
#include <queue>
using namespace std;

class Solution
{
public:
    int latestDayToCross(int row, int col, vector<vector<int>> &cells)
    {
        int l = 1;
        int r = row * col;
        while (l < r)
        {
            int m = r - (r - l) / 2;
            if (canCross(row, col, m, cells))
            {
                l = m;
            }
            else
            {
                r = m - 1;
            }
        }
        return l;
    }

    bool canCross(int row, int col, int day, vector<vector<int>> &cells)
    {
        vector<vector<int>> currGrid(row, vector<int>(col, 0));
        for (int i = 0; i < day; i++)
        {
            vector<int> floodedCell = cells[i];
            currGrid[floodedCell[0] - 1][floodedCell[1] - 1] = 1;
        }

        queue<pair<int, int>> q;
        for (int i = 0; i < col; i++)
        {
            if (currGrid[0][i] != 1)
            {
                q.push({0, i});
                currGrid[0][i] = -1;
            }
        }

        vector<pair<int, int>> moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.empty())
        {
            pair<int, int> currLoc = q.front();
            q.pop();
            int currRow = currLoc.first;
            int currCol = currLoc.second;
            if (currRow == row - 1)
                return true;
            for (auto move : moves)
            {
                int nextRow = currRow + move.first;
                int nextCol = currCol + move.second;
                if (nextRow >= 0 && nextRow < row &&
                    nextCol >= 0 && nextCol < col &&
                    currGrid[nextRow][nextCol] == 0)
                {
                    q.push({nextRow, nextCol});
                    currGrid[nextRow][nextCol] = -1;
                }
            }
        }
        return false;
    }
};