#include <vector>
using namespace std;

class Solution
{
public:
    int makeArrayIncreasing(vector<int> &arr1, vector<int> &arr2)
    {
        sort(arr2.begin(), arr2.end());
        vector<vector<int>> memo(arr1.size(), vector<int>(arr2.size() + 1, -1));
        int smallestOpNumber = dpHelper(0, -1, arr1, arr2, memo);
        return smallestOpNumber < 2001 ? smallestOpNumber : -1;
    }

private:
    int dpHelper(int i, int prev, vector<int> &arr1, vector<int> &arr2, vector<vector<int>> &memo)
    {
        // no more replacement is needed if i is at the end of arr1
        if (i == arr1.size())
            return 0;

        // get the index of the smallest value from arr2 that can be replaced into arr1
        int j = upper_bound(arr2.begin(), arr2.end(), prev) - arr2.begin();

        // if memo has been set, we know the answer from before
        if (memo[i][j] != -1)
            return memo[i][j];

        // if arr1[i] needs to be replaced, but we did not find a possible replacement from arr2
        if (arr1[i] <= prev && j == arr2.size())
            return -1;

        // case 1: make a replacement from arr2 into arr1:
        int replace = 2001;
        if (j != arr2.size())
        {
            replace = dpHelper(i + 1, arr2[j], arr1, arr2, memo) + 1;
        }

        // case 2: do not make a replacement from arr2 into arr1:
        int noReplace = 2001;
        if (arr1[i] > prev)
        {
            noReplace = dpHelper(i + 1, arr1[i], arr1, arr2, memo);
        }

        memo[i][j] = min(replace, noReplace);
        return memo[i][j];
    }
};