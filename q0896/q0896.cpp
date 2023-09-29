class Solution
{
public:
    bool isMonotonic(vector<int> &nums)
    {
        int monotonicStatus = 0;
        for (int i = 1; i < nums.size(); i++)
        {
            // increasing
            if (nums[i] > nums[i - 1])
            {
                if (monotonicStatus == -1)
                    return false;
                monotonicStatus = 1;
                // decreasing
            }
            else if (nums[i] < nums[i - 1])
            {
                if (monotonicStatus == 1)
                    return false;
                monotonicStatus = -1;
            }
        }
        return true;
    }
};