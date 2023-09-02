#include <vector>
using namespace std;

class Solution
{
public:
    void dfs(int node, vector<vector<int>> &isConnected, vector<bool> &isVisited)
    {
        isVisited[node] = true;
        int n = isVisited.size();
        for (int i = 0; i < n; i++)
        {
            // search for other city that is connected with the current city
            if (isConnected[node][i] && !isVisited[i])
            {
                dfs(i, isConnected, isVisited);
            }
        }
    }

    int findCircleNum(vector<vector<int>> &isConnected)
    {
        int n = isConnected.size();
        int res = 0;
        vector<bool> isVisited(n);
        for (int i = 0; i < n; i++)
        {
            // if the city has not been visited, perform dfs starting from the city
            if (!isVisited[i])
            {
                // add one to the total number of province
                res++;
                dfs(i, isConnected, isVisited);
            }
        }
        return res;
    }
};