#include <vector>
using namespace std;

class Solution
{
public:
    void rotate(vector<int> &nums, int k)
    {
        int l = nums.size();
        k = k % l;
        vector<int> temp(l);
        int j = 0;
        for (int i = l - k; i < l; i++)
        {
            temp[j++] = nums[i];
        }
        for (int i = 0; i < l - k; i++)
        {
            temp[j++] = nums[i];
        }
        for (int i = 0; i < l; i++)
        {
            nums[i] = temp[i];
        }
    }
};