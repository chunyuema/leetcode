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
            if (!isVisited[i])
            {
                res++;
                dfs(i, isConnected, isVisited);
            }
        }
        return res;
    }
};