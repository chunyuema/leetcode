class Solution
{
public:
    int minOperations(vector<int> &nums)
    {
        unordered_map<int, int> numCount;
        for (int num : nums)
            numCount[num]++;

        int totalOps = 0;
        for (const auto &[num, count] : numCount)
        {
            // cannot be eliminated with any operations
            if (count == 1)
                return -1;

            // use the operation to eliminate as many groups of 3 as possible
            // only the left over 1 pair is eliminated with the operation to remove pair
            totalOps += (count % 3 == 0) ? count / 3 : count / 3 + 1;
        }
        return totalOps;
    }
};