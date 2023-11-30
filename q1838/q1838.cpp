class Solution
{
public:
    int maxFrequency(vector<int> &nums, int k)
    {
        sort(nums.begin(), nums.end());
        int left = 0;
        long windowSum = 0;
        int res = 0;

        for (int right = 0; right < nums.size(); right++)
        {
            // expand the window
            long num = nums[right];
            windowSum += num;

            // shrink the window until condition met
            while (windowSum + k < (right - left + 1) * num)
            {
                windowSum -= nums[left];
                left++;
            }

            // update the res
            res = max(right - left + 1, res);
        }
        return res;
    }
};