#include <vector>
using namespace std;

class Solution
{
public:
    vector<int> constructArray(int n, int k)
    {
        vector<int> res;
        // first get the sequence from [1, 2, 3, ..., n-k-1]
        for (int i = 1; i < n - k; i++)
            res.push_back(i);

        // for the rest of the k numbers, alternate and pick the head and tail from the following:
        // [n-k, n-k+1, n-k+2, ..., n] to ensure that the difference is maintained
        for (int j = 0; j <= k; j++)
        {
            if (j % 2 == 0)
            {
                res.push_back(n - k + j / 2);
            }
            else
            {
                res.push_back(n - j / 2);
            }
        }
        return res;
    }
};