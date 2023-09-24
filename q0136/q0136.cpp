class Solution
{
public:
    int singleNumber(vector<int> &nums)
    {
        int res = nums[0];

        // a ^= a will clear the bits in all positions
        for (int i = 1; i < nums.size(); i++)
        {
            res ^= nums[i];
        }
        return res;
    }
};