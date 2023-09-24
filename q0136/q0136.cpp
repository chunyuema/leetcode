class Solution
{
public:
    int singleNumber(vector<int> &nums)
    {
        int res = 0;

        // a ^= a will clear the bits in all positions
        for (int num : nums)
        {
            res ^= num;
        }
        return res;
    }
};