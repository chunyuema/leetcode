class Solution
{
public:
    int maxDotProduct(vector<int> &nums1, vector<int> &nums2)
    {
        vector<vector<int>> memo(nums1.size(), vector<int>(nums2.size(), INT_MIN));
        return dpHelper(nums1, nums2, nums1.size() - 1, nums2.size() - 1, memo);
    }

private:
    int dpHelper(const vector<int> &nums1, const vector<int> &nums2, const int i, const int j, vector<vector<int>> &memo)
    {

        if (i < 0 || j < 0)
            return INT_MIN;

        if (memo[i][j] != INT_MIN)
            return memo[i][j];

        int sol1 = max(0, dpHelper(nums1, nums2, i - 1, j - 1, memo)) + nums1[i] * nums2[j];
        int sol2 = dpHelper(nums1, nums2, i - 1, j, memo);
        int sol3 = dpHelper(nums1, nums2, i, j - 1, memo);
        int res = max(sol1, max(sol2, sol3));
        memo[i][j] = res;
        return res;
    }
};