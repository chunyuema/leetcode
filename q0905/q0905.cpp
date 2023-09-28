class Solution
{
public:
    vector<int> sortArrayByParity(vector<int> &nums)
    {
        int l = 0;
        int r = nums.size() - 1;
        int i = 0;
        while (l < r)
        {
            if (nums[i] % 2 == 0)
            {
                swap(nums[i], nums[l]);
                l++;
                i++;
            }
            else
            {
                swap(nums[i], nums[r]);
                r--;
            }
        }
        return nums;
    }
};