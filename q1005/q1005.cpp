class Solution
{
public:
    /* Solution without using priority queue */
    int largestSumAfterKNegations(vector<int> &nums, int k)
    {
        sort(nums.begin(), nums.end());
        int i = 0;
        while (i < nums.size() and nums[i] < 0 and k > 0)
        {
            nums[i] = -nums[i];
            k--;
            i++;
        }
        if (k % 2 != 0)
        {
            sort(nums.begin(), nums.end());
            nums[0] = -nums[0];
        }
        int res = 0;
        for (int x : nums)
        {
            res += x;
        }
        return res;
    }

    /* Solution using priority queue */
    int largestSumAfterKNegationsWithPQ(vector<int> &nums, int k)
    {
        priority_queue<int, vector<int>, greater<int>> pq;
        for (int num : nums)
        {
            pq.push(num);
        }

        while (k > 0)
        {
            int smallest = pq.top();
            pq.pop();
            pq.push(-1 * smallest);
            k--;
        }

        int sum = 0;
        while (!pq.empty())
        {
            sum += pq.top();
            pq.pop();
        }

        return sum;
    }
};