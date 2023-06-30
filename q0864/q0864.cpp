#include <vector>
#include <string>
#include <set>
#include <queue>
using namespace std;

class Solution
{
public:
    int shortestPathAllKeys(vector<string> &grid)
    {
        int m = grid.size();
        int n = grid[0].size();
        set<int> keySet;
        set<int> lockSet;
        int startRow = -1;
        int startCol = -1;
        int keyState = 0;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                char c = grid[i][j];
                // a key if found => add to ket set
                if (c >= 'a' && c <= 'f')
                {
                    keyState += (1 << (c - 'a'));
                    keySet.insert(c);
                    // a lock is found => add to lock set
                }
                else if (c >= 'A' && c <= 'F')
                {
                    lockSet.insert(c);
                    // determine the beginning
                }
                else if (c == '@')
                {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        vector<pair<int, int>> moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int initialKeyState = 0;
        set<vector<int>> visited;
        visited.insert({initialKeyState, startRow, startCol});

        queue<vector<int>> q;
        q.push({startRow, startCol, initialKeyState, 0});
        while (!q.empty())
        {
            vector<int> currState = q.front();
            q.pop();
            int currRow = currState[0];
            int currCol = currState[1];
            int currKeyState = currState[2];
            int currPath = currState[3];
            for (auto move : moves)
            {
                int newRow = currRow + move.first;
                int newCol = currCol + move.second;
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] != '#')
                {
                    char c = grid[newRow][newCol];
                    if (keySet.find(c) != keySet.end())
                    {
                        // If the key has been collected before, there is not need to explore
                        if (((1 << (c - 'a')) & currKeyState) != 0)
                            continue;

                        // Collect the key and check if we have all the keys
                        int newKeyState = (currKeyState | (1 << (c - 'a')));

                        // If we have all the keys, return the path to obtain the last key
                        if (newKeyState == keyState)
                            return currPath + 1;

                        // If we do not have all the keys, generate a new state, add to visited
                        visited.insert({newKeyState, newRow, newCol});
                        q.push({newRow, newCol, newKeyState, currPath + 1});
                    }

                    // If we have a lock, but do not have a corresponding key, we cannot explore it
                    if ((lockSet.find(c) != lockSet.end()) && ((currKeyState & (1 << (c - 'A'))) == 0))
                    {
                        continue;
                    }

                    // If we do not see lock / key, it is a regular cell, there will not be a new keyState
                    // Check if we have already had this combination on the queue, if not, add it.
                    if (visited.find({currKeyState, newRow, newCol}) == visited.end())
                    {
                        visited.insert({currKeyState, newRow, newCol});
                        q.push({newRow, newCol, currKeyState, currPath + 1});
                    }
                }
            }
        }

        return -1;
    }
};