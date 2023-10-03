class Solution
{
public:
    int numIdenticalPairs(vector<int> &nums)
    {
        unordered_map<int, int> map;
        int res = 0;
        for (int num : nums)
        {
            res += map[num];
            map[num]++;
        }
        return res;
    }
};