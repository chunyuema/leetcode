class Solution
{
public:
    int maxValue(vector<vector<int>> &events, int k)
    {
        sort(events.begin(), events.end());
        vector<vector<int>> memo(events.size(), vector<int>(k + 1, -1));
        return dpHelper(0, events, k, memo);
    }

    int dpHelper(int currIdx, const vector<vector<int>> &events, int k, vector<vector<int>> &memo)
    {
        // if currIdx is out of range or we do not have any k left, return 0
        if (currIdx >= events.size() || k == 0)
            return 0;

        // if we previously have computed the value, return that value
        if (memo[currIdx][k] != -1)
            return memo[currIdx][k];

        // attend the current event, and recursively compute from the next compatible index (start after curr event ends)
        int nextCompatibleEventIdx = findNextCompatibleEventIdx(events, events[currIdx][1]);
        int val1 = events[currIdx][2] + dpHelper(nextCompatibleEventIdx, events, k - 1, memo);

        // do not attend the current event, and recursively compute from the immediate next index
        int val2 = dpHelper(currIdx + 1, events, k, memo);

        memo[currIdx][k] = max(val1, val2);
        return memo[currIdx][k];
    }

    int findNextCompatibleEventIdx(const vector<vector<int>> &events, int currEndTime)
    {
        int l = 0;
        int r = events.size();
        while (l < r)
        {
            int m = (l + r) / 2;
            if (events[m][0] <= currEndTime)
            {
                l = m + 1;
            }
            else
            {
                r = m;
            }
        }
        return l;
    }
};