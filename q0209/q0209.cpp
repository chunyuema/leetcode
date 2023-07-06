#include <vector>
using namespace std;

class Solution
{
public:
    int minSubArrayLen(int target, vector<int> &nums)
    {
        int minLen = INT_MAX;
        int currSum = 0;
        int l = 0;
        for (int r = 0; r < nums.size(); r++)
        {
            currSum += nums[r];
            while (currSum >= target)
            {
                minLen = min(minLen, r - l + 1);
                currSum -= nums[l];
                l++;
            }
        }
        return (minLen != INT_MAX) ? minLen : 0;
    }
};