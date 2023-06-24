#include <vector>
#include <unordered_map>
using namespace std;

class Solution
{
public:
    int tallestBillboard(vector<int> &rods)
    {
        unordered_map<int, int> dp = {{0, 0}};
        for (int r : rods)
        {
            unordered_map<int, int> new_dp = dp;
            for (auto &p : dp)
            {
                int diff = p.first;
                int taller = p.second;
                int shorter = taller - diff;

                // there is no need to update new_dp

                // add to the taller, increase the diff
                int new_taller_1 = taller + r;
                int bigger_diff = diff + r;
                int prev_new_taller_1 = new_dp.count(bigger_diff) ? new_dp[bigger_diff] : 0;
                new_dp[bigger_diff] = max(new_taller_1, prev_new_taller_1);

                // add to the shorter, decrease the diff
                int new_shorter = shorter + r;
                int new_taller_2 = max(new_shorter, taller);
                int smaller_diff = abs(new_shorter - taller);
                int prev_new_taller_2 = new_dp.count(smaller_diff) ? new_dp[smaller_diff] : 0;
                new_dp[smaller_diff] = max(new_taller_2, prev_new_taller_2);
            }
            dp = new_dp;
        }
        return (dp.count(0)) ? dp[0] : 0;
    }
};