class Solution
{
public:
    bool find132pattern(vector<int> &nums)
    {
        stack<vector<int>> stack;
        int currMinNum = nums[0];

        for (int i = 1; i < nums.size(); i++)
        {
            int num = nums[i];
            while (!stack.empty() && num >= stack.top()[0])
            {
                stack.pop();
            }
            if (!stack.empty() && num > stack.top()[1])
            {
                return true;
            }

            stack.push({num, currMinNum});
            currMinNum = min(num, currMinNum);
        }

        return false;
    }
};