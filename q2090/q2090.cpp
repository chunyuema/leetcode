#include <vector>
using namespace std;

class Solution
{
public:
    vector<int> getAverages(vector<int> &nums, int k)
    {
        if (k == 0)
            return nums;

        // By default, the positions are filled with -1
        int n = nums.size();
        vector<int> averages(n, -1);

        if (n < 2 * k + 1)
            return averages;

        // Compuet the first valid window sum
        long currentSum = 0;
        for (int i = 0; i <= 2 * k; i++)
        {
            currentSum += nums[i];
        }
        averages[k] = currentSum / (2 * k + 1);

        // At every index, subtract from left and add from the right. Then recompute the average
        for (int j = k + 1; j < n - k; j++)
        {
            int l = j - k - 1;
            int r = j + k;
            currentSum += nums[r];
            currentSum -= nums[l];
            averages[j] = currentSum / (2 * k + 1);
        }

        return averages;
    }
};