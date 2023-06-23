#include <vector>
#include <unordered_map>
using namespace std;

class Solution
{
public:
    int longestArithSeqLength(vector<int> &nums)
    {
        int maxLen = 0;
        int n = nums.size();
        vector<unordered_map<int, int>> memo(n);
        for (int r = 0; r < n; r++)
        {
            for (int l = 0; l < r; l++)
            {
                int diff = nums[r] - nums[l];
                if (memo[l].find(diff) != memo[l].end())
                {
                    memo[r][diff] = memo[l][diff] + 1;
                }
                else
                {
                    memo[r][diff] = 2;
                }
                maxLen = max(memo[r][diff], maxLen);
            }
        }
        return maxLen;
    }
};