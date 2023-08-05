class Solution
{
public:
    int maxProduct(vector<int> &nums)
    {
        int res = nums[0];
        int current_max = nums[0];
        int current_min = nums[0];

        for (int i = 1; i < nums.size(); i++)
        {
            int temp_max = max(nums[i],
                               max(current_max * nums[i],
                                   current_min * nums[i]));
            int temp_min = min(nums[i],
                               min(current_max * nums[i],
                                   current_min * nums[i]));
            current_max = temp_max;
            current_min = temp_min;
            res = max(res, current_max);
        }
        return res;
    }
};