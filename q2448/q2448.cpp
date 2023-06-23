#include <vector>
using namespace std;

class Solution
{
public:
    long long minCost(vector<int> &nums, vector<int> &cost)
    {
        long long minTotalCost = 0;
        int l = *min_element(nums.begin(), nums.end());
        int r = *max_element(nums.begin(), nums.end());
        while (l < r)
        {
            int m = (l + r) / 2;
            long long c1 = getCost(nums, cost, m);
            long long c2 = getCost(nums, cost, m + 1);
            if (c1 <= c2)
            {
                r = m;
                minTotalCost = c1;
            }
            else
            {
                l = m + 1;
                minTotalCost = c2;
            }
        }
        return minTotalCost;
    }

private:
    long long getCost(vector<int> &nums, vector<int> &cost, int target)
    {
        long long totalCost = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            totalCost += 1L * abs(nums[i] - target) * cost[i];
        }
        return totalCost;
    }
};