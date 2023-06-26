#include <vector>
#include <string>
using namespace std;

class Solution
{
public:
    vector<string> summaryRanges(vector<int> &nums)
    {
        vector<string> res;
        for (int i = 0; i < nums.size(); i++)
        {
            int start = nums[i];
            while (i + 1 < nums.size() && (nums[i + 1] == nums[i] + 1))
            {
                i++;
            }
            int end = nums[i];

            if (start == end)
                res.push_back(to_string(start));
            else
                res.push_back(to_string(start) + "->" + to_string(end));
        }
        return res;
    }
};