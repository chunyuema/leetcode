#include <vector>
using namespace std;

class Solution
{
public:
    int longestSubarray(vector<int> &nums)
    {
        int l = 0;
        int r = 0;
        int totalZeros = 0;
        int maxLen = 0;
        while (r < nums.size())
        {
            totalZeros += (nums[r] == 0 ? 1 : 0);

            while (totalZeros > 1)
            {
                totalZeros -= (nums[l] == 0 ? 1 : 0);
                l++;
            }

            maxLen = max(maxLen, r - l);
            r++;
        }
        return maxLen;
    }
};