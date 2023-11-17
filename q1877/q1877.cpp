class Solution
{
public:
    int minPairSum(vector<int> &nums)
    {
        sort(nums.begin(), nums.end());
        int minSum = INT_MIN;
        int l = 0;
        int r = nums.size() - 1;
        while (l < r)
        {
            minSum = max(nums[l] + nums[r], minSum);
            l++;
            r--;
        }
        return minSum;
    }
};