class Solution
{
public:
    int maxDotProduct(vector<int> &nums1, vector<int> &nums2)
    {
        vector<vector<int>> dp(nums1.size(), vector<int>(nums2.size()));
        for (int i = 0; i < nums1.size(); i++)
        {
            for (int j = 0; j < nums2.size(); j++)
            {
                dp[i][j] = nums1[i] * nums2[j];
                if (i > 0 && j > 0)
                    dp[i][j] += max(0, dp[i - 1][j - 1]);
                if (i > 0)
                    dp[i][j] = max(dp[i - 1][j], dp[i][j]);
                if (j > 0)
                    dp[i][j] = max(dp[i][j - 1], dp[i][j]);
            }
        }
        return dp[nums1.size() - 1][nums2.size() - 1];
    }
};