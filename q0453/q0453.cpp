class Solution
{
public:
    int minMoves(vector<int> &nums)
    {
        int minNum = INT_MAX;
        for (const int &num : nums)
        {
            minNum = min(minNum, num);
        }

        int moveCount = 0;
        for (const int &num : nums)
        {
            moveCount += num - minNum;
        }
        return moveCount;
    }
};