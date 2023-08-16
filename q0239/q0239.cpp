class Solution
{
public:
    vector<int> maxSlidingWindow(vector<int> &nums, int k)
    {
        int n = nums.size();
        vector<int> result(n - k + 1);
        deque<int> d;

        for (int i = 0; i < n; i++)
        {
            while (!d.empty() && i - d.front() >= k)
                d.pop_front();
            while (!d.empty() && nums[d.back()] <= nums[i])
                d.pop_back();
            d.push_back(i);
            if (i >= k - 1)
            {
                result[i + 1 - k] = nums[d.front()];
            }
        }
        return result;
    }
};