#include <vector>
using namespace std;

class Solution
{
public:
    int findDuplicate(vector<int> &nums)
    {
        for (auto num : nums)
        {
            int idx = abs(num);
            if (nums[idx - 1] < 0)
            {
                return idx;
            }
            nums[idx - 1] *= -1;
        }
        return -1;
    }
};