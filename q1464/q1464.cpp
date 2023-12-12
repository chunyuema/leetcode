class Solution
{
public:
    int maxProduct(vector<int> &nums)
    {
        int firstMax = INT_MIN;
        int secondMax = INT_MIN;
        for (const int num : nums)
        {
            if (num > firstMax)
            {
                secondMax = max(firstMax, secondMax);
                firstMax = num;
            }
            else if (num > secondMax)
            {
                secondMax = num;
            }
        }
        return (firstMax - 1) * (secondMax - 1);
    }
};