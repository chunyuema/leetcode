#include <vector>
using namespace std;

class Solution
{
public:
    void sortColors(vector<int> &nums)
    {
        int l = 0;
        int m = 0;
        int r = nums.size() - 1;
        while (m <= r)
        {
            if (nums[m] == 0)
            {
                swap(nums[m], nums[l]);
                l++;
                m++;
            }
            else if (nums[m] == 1)
            {
                m++;
            }
            else
            {
                swap(nums[m], nums[r]);
                r--;
            }
        }
    }
};