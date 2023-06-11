class Solution
{
public:
    int minSubArrayLen(int target, vector<int> &nums)
    {
        int min_len = INT_MAX;
        int curr_sum = 0;
        int l = 0;
        for (int r = 0; r < nums.size(); r++)
        {
            curr_sum += nums[r];
            while (curr_sum >= target)
            {
                min_len = min(min_len, r - l + 1);
                curr_sum -= nums[l];
                l++;
            }
        }
        return (min_len != INT_MAX) ? min_len : 0;
    }
};