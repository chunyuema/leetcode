#include <vector>
#include <queue>
using namespace std;

class Solution
{
public:
    long long totalCost(vector<int> &costs, int k, int candidates)
    {
        priority_queue<int, vector<int>, greater<int>> p1;
        priority_queue<int, vector<int>, greater<int>> p2;

        for (int i = 0; i < candidates; i++)
        {
            p1.push(costs[i]);
        }

        for (int j = max(candidates, (int)costs.size() - candidates); j < costs.size(); j++)
        {
            p2.push(costs[j]);
        }

        long long res = 0;
        int nextP1 = candidates;
        int nextP2 = costs.size() - candidates - 1;

        while (k > 0)
        {
            int c1 = !p1.empty() ? p1.top() : INT_MAX;
            int c2 = !p2.empty() ? p2.top() : INT_MAX;
            if (c1 <= c2)
            {
                res += c1;
                p1.pop();
                if (nextP1 <= nextP2)
                {
                    p1.push(costs[nextP1]);
                    nextP1++;
                }
            }
            else
            {
                res += c2;
                p2.pop();
                if (nextP1 <= nextP2)
                {
                    p2.push(costs[nextP2]);
                    nextP2--;
                }
            }
            k--;
        }
        return res;
    }
};